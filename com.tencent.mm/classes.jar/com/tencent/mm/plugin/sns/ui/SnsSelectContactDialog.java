package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog
  extends MMBaseActivity
{
  private GridView RvI;
  private a RvJ;
  private List<String> bMQ;
  
  public SnsSelectContactDialog()
  {
    AppMethodBeat.i(99009);
    this.RvI = null;
    this.RvJ = null;
    this.bMQ = new LinkedList();
    AppMethodBeat.o(99009);
  }
  
  private boolean baJ(String paramString)
  {
    AppMethodBeat.i(99012);
    String[] arrayOfString = ab.oko;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        AppMethodBeat.o(99012);
        return false;
      }
      i += 1;
    }
    if (au.bwE(paramString))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    if (ab.IS(paramString))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    if ((this.bMQ != null) && (this.bMQ.contains(paramString)))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    AppMethodBeat.o(99012);
    return true;
  }
  
  private String hpj()
  {
    AppMethodBeat.i(99013);
    Object localObject1 = ((n)h.ax(n.class)).bzG();
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = ab.oko;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localLinkedList.add(localObject2[i]);
      i += 1;
    }
    localLinkedList.add("weixin");
    localLinkedList.add("officialaccounts");
    localLinkedList.add("helper_entry");
    localLinkedList.add("filehelper");
    localObject1 = ((by)localObject1).a(1, localLinkedList, "*");
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(99013);
      return "";
    }
    localLinkedList = new LinkedList();
    ((Cursor)localObject1).moveToFirst();
    do
    {
      localObject2 = new bb();
      ((bb)localObject2).convertFrom((Cursor)localObject1);
      if (baJ(((bd)localObject2).field_username))
      {
        localLinkedList.add(((bd)localObject2).field_username);
        if (localLinkedList.size() >= 10) {
          break;
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    localObject1 = Util.listToString(localLinkedList, ";");
    AppMethodBeat.o(99013);
    return localObject1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99014);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(99014);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99014);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99014);
        return;
      }
      paramIntent = Util.stringsToList(paramIntent.getStringExtra("Select_Contact").split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(99014);
        return;
      }
      if (this.bMQ == null) {
        this.bMQ = new LinkedList();
      }
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        if (!this.bMQ.contains(str)) {
          this.bMQ.add(str);
        }
      }
      Log.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.bMQ.size());
      if (this.RvJ != null)
      {
        Log.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
        this.RvJ.bDL();
      }
      paramIntent = new Intent();
      paramIntent.putExtra("Select_Contact", Util.listToString(this.bMQ, ","));
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99010);
    super.onCreate(paramBundle);
    setContentView(b.g.sns_chose_pic_ui);
    paramBundle = getIntent().getStringExtra("Select_Contact");
    if ((paramBundle == null) || (paramBundle.equals(""))) {
      this.bMQ.clear();
    }
    for (;;)
    {
      this.RvI = ((GridView)findViewById(b.f.content_grid));
      this.RvJ = new a(this, this.bMQ);
      this.RvI.setAdapter(this.RvJ);
      this.RvI.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(99003);
          b localb = new b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          a.c("com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          if (paramAnonymousInt == SnsSelectContactDialog.a(SnsSelectContactDialog.this).getCount() - 1) {
            SnsSelectContactDialog.b(SnsSelectContactDialog.this);
          }
          for (;;)
          {
            SnsSelectContactDialog.a(SnsSelectContactDialog.this).bDL();
            a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(99003);
            return;
            SnsSelectContactDialog.c(SnsSelectContactDialog.this).remove(paramAnonymousInt);
          }
        }
      });
      this.RvI.setSelection(this.RvJ.getCount() - 1);
      ((ImageButton)findViewById(b.f.close_btn)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99004);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Select_Contact", Util.listToString(SnsSelectContactDialog.c(SnsSelectContactDialog.this), ","));
          SnsSelectContactDialog.this.setResult(-1, paramAnonymousView);
          SnsSelectContactDialog.this.finish();
          a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99004);
        }
      });
      AppMethodBeat.o(99010);
      return;
      this.bMQ = Util.stringsToList(paramBundle.split(","));
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99011);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Contact", Util.listToString(this.bMQ, ","));
      setResult(-1, localIntent);
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(99011);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private int Rao;
    private List<String> bMQ;
    private Context context;
    private int type;
    
    public a(List<String> paramList)
    {
      AppMethodBeat.i(99005);
      this.Rao = 0;
      Object localObject;
      this.bMQ = localObject;
      this.context = paramList;
      this.type = 0;
      bDL();
      AppMethodBeat.o(99005);
    }
    
    public final void bDL()
    {
      AppMethodBeat.i(99006);
      if (this.bMQ == null) {}
      for (this.Rao = 0;; this.Rao = this.bMQ.size())
      {
        this.Rao += 1;
        notifyDataSetChanged();
        AppMethodBeat.o(99006);
        return;
      }
    }
    
    public final int getCount()
    {
      return this.Rao;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(99007);
      Object localObject = this.bMQ.get(paramInt);
      AppMethodBeat.o(99007);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(99008);
      if (paramView == null)
      {
        paramViewGroup = new SnsSelectContactDialog.b();
        if (this.type == 0)
        {
          paramView = View.inflate(this.context, b.g.sns_upload_alert_item, null);
          paramViewGroup.Fjt = ((ImageView)paramView.findViewById(b.f.image));
          paramViewGroup.RvL = ((ImageView)paramView.findViewById(b.f.item_del));
          paramView.setTag(paramViewGroup);
          label69:
          paramView.setVisibility(0);
          if (paramInt != this.Rao - 1) {
            break label175;
          }
          paramViewGroup.Fjt.setBackgroundDrawable(null);
          paramViewGroup.Fjt.setImageResource(b.e.sns_add_item);
          paramViewGroup.RvL.setVisibility(8);
          if (this.bMQ.size() >= as.acHp) {
            paramView.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        paramViewGroup.Fjt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        AppMethodBeat.o(99008);
        return paramView;
        paramView = View.inflate(this.context, b.g.sns_alert_item, null);
        break;
        paramViewGroup = (SnsSelectContactDialog.b)paramView.getTag();
        break label69;
        label175:
        paramViewGroup.Fjt.setBackgroundDrawable(null);
        paramViewGroup.RvL.setVisibility(0);
        Object localObject;
        if (this.type == 0)
        {
          localObject = (String)this.bMQ.get(paramInt);
          a.b.g(paramViewGroup.Fjt, (String)localObject);
        }
        else
        {
          localObject = BitmapUtil.extractThumbNail((String)this.bMQ.get(paramInt), al.hgP(), al.hgP(), true);
          paramViewGroup.Fjt.setImageBitmap((Bitmap)localObject);
        }
      }
    }
  }
  
  static final class b
  {
    ImageView Fjt;
    ImageView RvL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog
 * JD-Core Version:    0.7.0.1
 */