package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SnsChatRoomMemberUI
  extends MMActivity
{
  private static int gzT = 5;
  private GridView EAK;
  private b EAL;
  private List<a> dSU;
  private com.tencent.mm.plugin.messenger.foundation.a.l gAd;
  private ah gtd;
  private String gwx;
  private String gxP;
  private int gxQ;
  private String gxR;
  private boolean gxS;
  private String mTitle;
  
  public SnsChatRoomMemberUI()
  {
    AppMethodBeat.i(98527);
    this.EAK = null;
    this.EAL = null;
    this.dSU = new ArrayList();
    AppMethodBeat.o(98527);
  }
  
  private static int cq(Context paramContext)
  {
    AppMethodBeat.i(98528);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(2131165518) * 2.0F + paramContext.getResources().getDimension(2131165526));
    i = (int)((i - paramContext.getResources().getDimension(2131165507) * 1.0F) / j);
    Log.i("MicroMsg.SnsChatRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    gzT = i;
    AppMethodBeat.o(98528);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131496421;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98530);
    super.onConfigurationChanged(paramConfiguration);
    this.EAK.setNumColumns(cq(this));
    AppMethodBeat.o(98530);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98529);
    super.onCreate(paramBundle);
    this.gAd = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class));
    this.gwx = getIntent().getStringExtra("RoomInfo_Id");
    this.gxP = getIntent().getStringExtra("room_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.gxQ = getIntent().getIntExtra("room_member_count", 0);
    this.gtd = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.gwx);
    if (this.gtd != null)
    {
      this.gxR = this.gtd.field_roomowner;
      this.gxS = z.aTY().equals(this.gxR);
    }
    this.EAK = ((GridView)findViewById(2131308091));
    this.EAK.setNumColumns(cq(this));
    this.EAK.setColumnWidth(getResources().getDimensionPixelSize(2131165507));
    this.EAK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(98521);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousAdapterView);
        ((b)localObject).bm(paramAnonymousView);
        ((b)localObject).pH(paramAnonymousInt);
        ((b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
        if (SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).ZG(paramAnonymousInt).type == 1)
        {
          as localas = SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this).ZG(paramAnonymousInt).contact;
          if (localas == null)
          {
            Log.e("MicroMsg.SnsChatRoomMemberUI", "cont is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(98521);
            return;
          }
          localObject = localas.field_username;
          String str = localas.field_nickname;
          paramAnonymousView = SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.b(SnsChatRoomMemberUI.this), (String)localObject);
          paramAnonymousAdapterView = paramAnonymousView;
          if (Util.isNullOrNil(paramAnonymousView)) {
            paramAnonymousAdapterView = localas.arJ();
          }
          SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this, (String)localObject, paramAnonymousAdapterView, str);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(98521);
      }
    });
    this.EAL = new b(this, this.gtd, this.gwx, this.gxR);
    this.EAK.setAdapter(this.EAL);
    paramBundle = v.Ic(this.gwx);
    if (paramBundle != null)
    {
      this.dSU.clear();
      int i = 0;
      if (i < paramBundle.size())
      {
        as localas = this.gAd.aSN().Kn((String)paramBundle.get(i));
        if ((localas != null) && (com.tencent.mm.contact.c.oR(localas.field_type)) && (!z.Im(localas.field_username)))
        {
          if (!this.gtd.JO(localas.field_username)) {
            break label353;
          }
          this.dSU.add(new a(localas, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          label353:
          if (this.gtd.bjf(localas.field_username)) {
            this.dSU.add(new a(localas, 2));
          } else {
            this.dSU.add(new a(localas, 1));
          }
        }
      }
      Collections.sort(this.dSU, new Comparator() {});
      this.EAL.notifyDataSetChanged();
    }
    setMMTitle(this.mTitle + "(" + this.dSU.size() + ")");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98522);
        SnsChatRoomMemberUI.this.setResult(0);
        SnsChatRoomMemberUI.this.finish();
        AppMethodBeat.o(98522);
        return true;
      }
    });
    AppMethodBeat.o(98529);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    as contact;
    int order = 0;
    int type = 1;
    
    public a(as paramas, int paramInt)
    {
      this.contact = paramas;
      this.order = paramInt;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private boolean gAa = false;
    private String gAb = null;
    private ah gtd;
    private List<String> gzY;
    private Context mContext;
    private String roomId;
    
    public b(ah paramah, String paramString, List<String> paramList)
    {
      this.gtd = paramString;
      this.roomId = paramList;
      this.gzY = null;
      Object localObject;
      this.gAb = localObject;
      this.mContext = paramah;
    }
    
    public final SnsChatRoomMemberUI.a ZG(int paramInt)
    {
      AppMethodBeat.i(98523);
      SnsChatRoomMemberUI.a locala = (SnsChatRoomMemberUI.a)SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this).get(paramInt);
      AppMethodBeat.o(98523);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(98525);
      int i = SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this).size();
      AppMethodBeat.o(98525);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(98524);
      View localView;
      SnsChatRoomMemberUI.c localc;
      String str;
      if (paramView == null)
      {
        localView = View.inflate(this.mContext, 2131496420, null);
        localc = new SnsChatRoomMemberUI.c((byte)0);
        localc.gvv = ((ImageView)localView.findViewById(2131307477));
        localc.gwR = ((TextView)localView.findViewById(2131307479));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.gwR.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.gAg = ((TextView)localView.findViewById(2131307480));
        localView.setTag(localc);
        if (localc.gAg != null) {
          localc.gAg.setVisibility(8);
        }
        paramView = (SnsChatRoomMemberUI.a)SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this).get(paramInt);
        if ((paramView != null) && (paramView.type == 1))
        {
          as localas = paramView.contact;
          a.b.c(localc.gvv, localas.field_username);
          str = SnsChatRoomMemberUI.c(this.gtd, localas.field_username);
          if (Util.isNullOrNil(localas.field_conRemark)) {
            break label376;
          }
          paramViewGroup = localas.field_conRemark;
          label214:
          paramView = paramViewGroup;
          if (Util.isNullOrNil(paramViewGroup)) {
            paramView = localas.arI();
          }
          paramViewGroup = paramView;
          if (str != null)
          {
            paramViewGroup = paramView;
            if (!str.equals(""))
            {
              paramViewGroup = paramView;
              if (!paramView.equals(str)) {
                paramViewGroup = str + "( " + paramView + " )";
              }
            }
          }
          localc.gwR.setVisibility(0);
          localc.gwR.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, paramViewGroup, localc.gwR.getTextSize()));
          if (localc.gAg != null)
          {
            paramView = com.tencent.mm.openim.room.a.a.O(localas);
            if (!TextUtils.isEmpty(paramView)) {
              break label382;
            }
            localc.gAg.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(98524);
        return localView;
        localc = (SnsChatRoomMemberUI.c)paramView.getTag();
        localView = paramView;
        break;
        label376:
        paramViewGroup = str;
        break label214;
        label382:
        localc.gAg.setVisibility(0);
        localc.gAg.setText(paramView);
      }
    }
  }
  
  static final class c
  {
    public TextView gAg;
    public ImageView gvv;
    public TextView gwR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */