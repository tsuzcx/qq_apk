package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
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
import com.tencent.mm.g.c.ba;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog
  extends MMBaseActivity
{
  private GridView Ayr;
  private a Ays;
  private List<String> hMc;
  
  public SnsSelectContactDialog()
  {
    AppMethodBeat.i(99009);
    this.Ayr = null;
    this.Ays = null;
    this.hMc = new LinkedList();
    AppMethodBeat.o(99009);
  }
  
  private boolean aCh(String paramString)
  {
    AppMethodBeat.i(99012);
    String[] arrayOfString = x.hIe;
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
    if (x.wb(paramString))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    if (x.Ao(paramString))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    if ((this.hMc != null) && (this.hMc.contains(paramString)))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    AppMethodBeat.o(99012);
    return true;
  }
  
  private String egc()
  {
    AppMethodBeat.i(99013);
    Object localObject1 = ((l)g.ab(l.class)).azL();
    Object localObject2 = x.hHV;
    Object localObject3 = new LinkedList();
    String[] arrayOfString = x.hIe;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      ((List)localObject3).add(arrayOfString[i]);
      i += 1;
    }
    ((List)localObject3).add("weixin");
    ((List)localObject3).add("officialaccounts");
    ((List)localObject3).add("helper_entry");
    ((List)localObject3).add("filehelper");
    localObject1 = ((br)localObject1).c((String)localObject2, (List)localObject3, "*");
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(99013);
      return "";
    }
    localObject2 = new LinkedList();
    ((Cursor)localObject1).moveToFirst();
    do
    {
      localObject3 = new au();
      ((au)localObject3).convertFrom((Cursor)localObject1);
      if (aCh(((ba)localObject3).field_username))
      {
        ((List)localObject2).add(((ba)localObject3).field_username);
        if (((List)localObject2).size() >= 10) {
          break;
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    localObject1 = bu.m((List)localObject2, ";");
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
      paramIntent = bu.U(paramIntent.getStringExtra("Select_Contact").split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(99014);
        return;
      }
      if (this.hMc == null) {
        this.hMc = new LinkedList();
      }
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        if (!this.hMc.contains(str)) {
          this.hMc.add(str);
        }
      }
      ae.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.hMc.size());
      if (this.Ays != null)
      {
        ae.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
        this.Ays.refresh();
      }
      paramIntent = new Intent();
      paramIntent.putExtra("Select_Contact", bu.m(this.hMc, ","));
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99010);
    super.onCreate(paramBundle);
    setContentView(2131495534);
    paramBundle = getIntent().getStringExtra("Select_Contact");
    if ((paramBundle == null) || (paramBundle.equals(""))) {
      this.hMc.clear();
    }
    for (;;)
    {
      this.Ayr = ((GridView)findViewById(2131298755));
      this.Ays = new a(this, this.hMc);
      this.Ayr.setAdapter(this.Ays);
      this.Ayr.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(99003);
          b localb = new b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          a.b("com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          if (paramAnonymousInt == SnsSelectContactDialog.a(SnsSelectContactDialog.this).getCount() - 1) {
            SnsSelectContactDialog.b(SnsSelectContactDialog.this);
          }
          for (;;)
          {
            SnsSelectContactDialog.a(SnsSelectContactDialog.this).refresh();
            a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(99003);
            return;
            SnsSelectContactDialog.c(SnsSelectContactDialog.this).remove(paramAnonymousInt);
          }
        }
      });
      this.Ayr.setSelection(this.Ays.getCount() - 1);
      ((ImageButton)findViewById(2131298364)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99004);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Select_Contact", bu.m(SnsSelectContactDialog.c(SnsSelectContactDialog.this), ","));
          SnsSelectContactDialog.this.setResult(-1, paramAnonymousView);
          SnsSelectContactDialog.this.finish();
          a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99004);
        }
      });
      AppMethodBeat.o(99010);
      return;
      this.hMc = bu.U(paramBundle.split(","));
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99011);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Contact", bu.m(this.hMc, ","));
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
    private int Afb;
    private Context context;
    private List<String> hMc;
    private int type;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(99005);
      this.Afb = 0;
      Object localObject;
      this.hMc = localObject;
      this.context = paramInt;
      this.type = 0;
      refresh();
      AppMethodBeat.o(99005);
    }
    
    public final int getCount()
    {
      return this.Afb;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(99007);
      Object localObject = this.hMc.get(paramInt);
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
          paramView = View.inflate(this.context, 2131495617, null);
          paramViewGroup.image = ((ImageView)paramView.findViewById(2131300914));
          paramViewGroup.Ayu = ((ImageView)paramView.findViewById(2131301148));
          paramView.setTag(paramViewGroup);
          label66:
          paramView.setVisibility(0);
          if (paramInt != this.Afb - 1) {
            break label170;
          }
          paramViewGroup.image.setBackgroundDrawable(null);
          paramViewGroup.image.setImageResource(2131234098);
          paramViewGroup.Ayu.setVisibility(8);
          if (this.hMc.size() >= al.IKg) {
            paramView.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        paramViewGroup.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        AppMethodBeat.o(99008);
        return paramView;
        paramView = View.inflate(this.context, 2131495526, null);
        break;
        paramViewGroup = (SnsSelectContactDialog.b)paramView.getTag();
        break label66;
        label170:
        paramViewGroup.image.setBackgroundDrawable(null);
        paramViewGroup.Ayu.setVisibility(0);
        Object localObject;
        if (this.type == 0)
        {
          localObject = (String)this.hMc.get(paramInt);
          a.b.c(paramViewGroup.image, (String)localObject);
        }
        else
        {
          localObject = h.d((String)this.hMc.get(paramInt), ah.dXP(), ah.dXP(), true);
          paramViewGroup.image.setImageBitmap((Bitmap)localObject);
        }
      }
    }
    
    public final void refresh()
    {
      AppMethodBeat.i(99006);
      if (this.hMc == null) {}
      for (this.Afb = 0;; this.Afb = this.hMc.size())
      {
        this.Afb += 1;
        notifyDataSetChanged();
        AppMethodBeat.o(99006);
        return;
      }
    }
  }
  
  static final class b
  {
    ImageView Ayu;
    ImageView image;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog
 * JD-Core Version:    0.7.0.1
 */