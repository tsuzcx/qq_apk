package com.tencent.mm.plugin.setting.ui.setting.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.j;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sensitive.d;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.f;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/view/SettingPermissionView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "business", "", "mContext", "mItemNameTextView", "Landroid/widget/TextView;", "mItemStatusTextView", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "permission", "root", "Landroid/view/View;", "init", "", "initAttribute", "showDialog", "Companion", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SettingPermissionView
  extends FrameLayout
{
  public static final SettingPermissionView.a PxV;
  private static final String Pya;
  private static final String Pyb;
  private static final List<String> Pyc;
  private static final List<String> Pyd;
  private String PxW;
  private String PxX;
  private TextView PxY;
  private TextView PxZ;
  private MultiProcessMMKV eMf;
  private View lBX;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(299098);
    PxV = new SettingPermissionView.a((byte)0);
    Pya = "unknown_permission";
    Pyb = "unknown_business";
    Pyc = p.listOf(new String[] { "chatting", "radar", "face2face_group", "sns", "finder", "live", "scan", "shake", "story", "search", "nearby", "game", "nearby_appbrand", "mine", "status", "fav", "card", "musicplayer", "net_check", "wifi_info", "pay", "biz", "webview", "contact", "emoji", "sport", "mail", "voiceprint", "add_contact", "contact_remark", "wechatout", "savefile", "appbrand" });
    Pyd = p.listOf(new String[] { "location", "contact", "storage", "camera", "microphone", "bluetooth", "healthy", "overlay" });
    AppMethodBeat.o(299098);
  }
  
  public SettingPermissionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(299036);
    b(paramAttributeSet, 0);
    init(paramContext);
    AppMethodBeat.o(299036);
  }
  
  public SettingPermissionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(299043);
    b(paramAttributeSet, paramInt);
    init(paramContext);
    AppMethodBeat.o(299043);
  }
  
  private static final void a(SettingPermissionView paramSettingPermissionView)
  {
    Object localObject4 = null;
    AppMethodBeat.i(299083);
    kotlin.g.b.s.u(paramSettingPermissionView, "this$0");
    Object localObject2 = paramSettingPermissionView.PxZ;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mItemStatusTextView");
      localObject1 = null;
    }
    Object localObject3 = paramSettingPermissionView.eMf;
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("mmkv");
      localObject2 = null;
    }
    String str = paramSettingPermissionView.PxX;
    localObject3 = str;
    if (str == null)
    {
      kotlin.g.b.s.bIx("business");
      localObject3 = null;
    }
    if (((MultiProcessMMKV)localObject2).getBoolean((String)localObject3, false))
    {
      paramSettingPermissionView = (CharSequence)"";
      localObject1.setText(paramSettingPermissionView);
      AppMethodBeat.o(299083);
      return;
    }
    paramSettingPermissionView = paramSettingPermissionView.mContext;
    if (paramSettingPermissionView == null)
    {
      kotlin.g.b.s.bIx("mContext");
      paramSettingPermissionView = localObject4;
    }
    for (;;)
    {
      paramSettingPermissionView = (CharSequence)paramSettingPermissionView.getString(b.i.settings_permission_denied);
      break;
    }
  }
  
  private static final void a(SettingPermissionView paramSettingPermissionView, View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(299069);
    Object localObject1 = new Object();
    Object localObject3 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramSettingPermissionView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/view/SettingPermissionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject3).aYj());
    kotlin.g.b.s.u(paramSettingPermissionView, "this$0");
    f localf = new f(paramSettingPermissionView.getContext(), 1, false);
    paramView = View.inflate(paramSettingPermissionView.getContext(), b.g.setting_permission_location_half_layout, null);
    if (paramView == null)
    {
      paramSettingPermissionView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
      AppMethodBeat.o(299069);
      throw paramSettingPermissionView;
    }
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = (RoundedCornerFrameLayout)paramView;
    localRoundedCornerFrameLayout.A(bd.fromDPToPix(paramSettingPermissionView.getContext(), 12), bd.fromDPToPix(paramSettingPermissionView.getContext(), 12), 0.0F, 0.0F);
    View localView = localRoundedCornerFrameLayout.findViewById(b.f.close);
    MMSwitchBtn localMMSwitchBtn = (MMSwitchBtn)localRoundedCornerFrameLayout.findViewById(b.f.switch_btn);
    localObject3 = (TextView)localRoundedCornerFrameLayout.findViewById(b.f.title);
    Object localObject4 = (TextView)localRoundedCornerFrameLayout.findViewById(b.f.desc);
    TextView localTextView = (TextView)localRoundedCornerFrameLayout.findViewById(b.f.switch_desc);
    paramView = com.tencent.mm.sensitive.business.a.acuK;
    Object localObject5 = com.tencent.mm.sensitive.business.a.iUd();
    localObject1 = paramSettingPermissionView.PxX;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("business");
      paramView = null;
    }
    ((TextView)localObject3).setText((CharSequence)((HashMap)localObject5).get(paramView));
    aw.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
    localObject5 = (d)h.az(d.class);
    localObject1 = paramSettingPermissionView.PxW;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("permission");
      paramView = null;
    }
    localObject3 = paramSettingPermissionView.PxX;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("business");
      localObject1 = null;
    }
    localObject1 = ((d)localObject5).getPermissionBusinessDesc(paramView, (String)localObject1);
    if (localObject1 != null)
    {
      paramView = paramSettingPermissionView.getContext();
      localObject1 = ((Pair)localObject1).first;
      kotlin.g.b.s.s(localObject1, "it.first");
      ((TextView)localObject4).setText((CharSequence)paramView.getString(((Number)localObject1).intValue()));
    }
    localObject3 = paramSettingPermissionView.getContext();
    int i = b.i.settings_permission_half_switch_desc;
    paramView = com.tencent.mm.sensitive.business.a.acuK;
    localObject4 = com.tencent.mm.sensitive.business.a.iUc();
    localObject1 = paramSettingPermissionView.PxW;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("permission");
      paramView = null;
    }
    localTextView.setText((CharSequence)((Context)localObject3).getString(i, new Object[] { ((HashMap)localObject4).get(paramView) }));
    localView.setOnClickListener(new SettingPermissionView..ExternalSyntheticLambda1(localf));
    localObject1 = paramSettingPermissionView.eMf;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mmkv");
      paramView = null;
    }
    localObject1 = paramSettingPermissionView.PxX;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("business");
      localObject1 = localObject2;
    }
    for (;;)
    {
      localMMSwitchBtn.setCheck(paramView.getBoolean((String)localObject1, true));
      localMMSwitchBtn.setSwitchListener(new SettingPermissionView..ExternalSyntheticLambda3(paramSettingPermissionView));
      localf.aeLi = new SettingPermissionView..ExternalSyntheticLambda4(paramSettingPermissionView);
      localf.Vtg = new SettingPermissionView..ExternalSyntheticLambda2(localf, localRoundedCornerFrameLayout);
      localf.uR(true);
      localf.dDn();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/view/SettingPermissionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(299069);
      return;
    }
  }
  
  private static final void a(SettingPermissionView paramSettingPermissionView, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(299079);
    kotlin.g.b.s.u(paramSettingPermissionView, "this$0");
    MultiProcessMMKV localMultiProcessMMKV2 = paramSettingPermissionView.eMf;
    MultiProcessMMKV localMultiProcessMMKV1 = localMultiProcessMMKV2;
    if (localMultiProcessMMKV2 == null)
    {
      kotlin.g.b.s.bIx("mmkv");
      localMultiProcessMMKV1 = null;
    }
    paramSettingPermissionView = paramSettingPermissionView.PxX;
    if (paramSettingPermissionView == null)
    {
      kotlin.g.b.s.bIx("business");
      paramSettingPermissionView = localObject;
      localMultiProcessMMKV1.putBoolean(paramSettingPermissionView, paramBoolean);
      paramSettingPermissionView = com.tencent.mm.sensitive.d.b.acvJ;
      if (!paramBoolean) {
        break label89;
      }
    }
    label89:
    for (long l = 104L;; l = 103L)
    {
      com.tencent.mm.sensitive.d.b.report(l);
      AppMethodBeat.o(299079);
      return;
      break;
    }
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(299050);
    Object localObject2 = getContext().obtainStyledAttributes(paramAttributeSet, b.j.MMPermission, paramInt, 0);
    kotlin.g.b.s.s(localObject2, "context.obtainStyledAttr…MPermission, defStyle, 0)");
    paramAttributeSet = Integer.valueOf(((TypedArray)localObject2).getInt(b.j.MMPermission_MMPermissionType, -1));
    paramInt = ((Number)paramAttributeSet).intValue();
    label72:
    label78:
    Object localObject1;
    if (paramInt > 0) {
      if (paramInt <= Pyd.size())
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label225;
        }
        if (paramAttributeSet != null) {
          break label230;
        }
        paramAttributeSet = null;
        localObject1 = paramAttributeSet;
        if (paramAttributeSet == null) {
          localObject1 = Pya;
        }
        this.PxW = ((String)localObject1);
        paramAttributeSet = Integer.valueOf(((TypedArray)localObject2).getInt(b.j.MMPermission_MMBusinessType, -1));
        paramInt = ((Number)paramAttributeSet).intValue();
        if (paramInt <= 0) {
          break label261;
        }
        if (paramInt > Pyc.size()) {
          break label256;
        }
        paramInt = 1;
        label132:
        if (paramInt == 0) {
          break label266;
        }
        label136:
        if (paramAttributeSet != null) {
          break label271;
        }
      }
    }
    for (paramAttributeSet = null;; paramAttributeSet = (String)Pyc.get(paramInt - 1))
    {
      localObject1 = paramAttributeSet;
      if (paramAttributeSet == null) {
        localObject1 = Pyb;
      }
      this.PxX = ((String)localObject1);
      localObject2 = (d)h.az(d.class);
      localObject1 = this.PxW;
      paramAttributeSet = (AttributeSet)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("permission");
        paramAttributeSet = null;
      }
      paramAttributeSet = ((d)localObject2).getPermissionConfigMMkv(paramAttributeSet);
      kotlin.g.b.s.s(paramAttributeSet, "plugin(IPluginSensitive:…ionConfigMMkv(permission)");
      this.eMf = paramAttributeSet;
      AppMethodBeat.o(299050);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break;
      label225:
      paramAttributeSet = null;
      break label72;
      label230:
      paramInt = ((Number)paramAttributeSet).intValue();
      paramAttributeSet = (String)Pyd.get(paramInt - 1);
      break label78;
      label256:
      paramInt = 0;
      break label132;
      label261:
      paramInt = 0;
      break label132;
      label266:
      paramAttributeSet = null;
      break label136;
      label271:
      paramInt = ((Number)paramAttributeSet).intValue();
    }
  }
  
  private static final void b(f paramf, View paramView)
  {
    AppMethodBeat.i(299073);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/view/SettingPermissionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "$dialog");
    paramf.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/view/SettingPermissionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299073);
  }
  
  private static final void b(f paramf, RoundedCornerFrameLayout paramRoundedCornerFrameLayout, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(299089);
    kotlin.g.b.s.u(paramf, "$dialog");
    kotlin.g.b.s.u(paramRoundedCornerFrameLayout, "$rootViewContainer");
    params.clear();
    paramf.setFooterView(null);
    paramf.setFooterView((View)paramRoundedCornerFrameLayout);
    AppMethodBeat.o(299089);
  }
  
  private final void init(Context paramContext)
  {
    Object localObject3 = null;
    AppMethodBeat.i(299055);
    this.mContext = paramContext;
    Object localObject1 = this.mContext;
    paramContext = (Context)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mContext");
      paramContext = null;
    }
    paramContext = af.mU(paramContext).inflate(b.g.setting_permission_item_view_layout, (ViewGroup)this);
    kotlin.g.b.s.s(paramContext, "getInflater(mContext)\n  …n_item_view_layout, this)");
    this.lBX = paramContext;
    localObject1 = this.lBX;
    paramContext = (Context)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("root");
      paramContext = null;
    }
    paramContext = paramContext.findViewById(b.f.permission_switch_title);
    kotlin.g.b.s.s(paramContext, "root.findViewById(R.id.permission_switch_title)");
    this.PxY = ((TextView)paramContext);
    localObject1 = this.lBX;
    paramContext = (Context)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("root");
      paramContext = null;
    }
    paramContext = paramContext.findViewById(b.f.permission_switch_desc);
    kotlin.g.b.s.s(paramContext, "root.findViewById(R.id.permission_switch_desc)");
    this.PxZ = ((TextView)paramContext);
    paramContext = this.PxY;
    Object localObject2;
    if (paramContext == null)
    {
      kotlin.g.b.s.bIx("mItemNameTextView");
      paramContext = null;
      localObject1 = com.tencent.mm.sensitive.business.a.acuK;
      Object localObject4 = com.tencent.mm.sensitive.business.a.iUd();
      localObject2 = this.PxX;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("business");
        localObject1 = null;
      }
      paramContext.setText((CharSequence)((HashMap)localObject4).get(localObject1));
      paramContext = this.PxZ;
      if (paramContext != null) {
        break label316;
      }
      kotlin.g.b.s.bIx("mItemStatusTextView");
      paramContext = null;
      label217:
      localObject2 = this.eMf;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mmkv");
        localObject1 = null;
      }
      localObject4 = this.PxX;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        kotlin.g.b.s.bIx("business");
        localObject2 = null;
      }
      if (!((MultiProcessMMKV)localObject1).getBoolean((String)localObject2, true)) {
        break label319;
      }
      localObject1 = (CharSequence)"";
      label271:
      paramContext.setText((CharSequence)localObject1);
      paramContext = this.lBX;
      if (paramContext != null) {
        break label352;
      }
      kotlin.g.b.s.bIx("root");
      paramContext = localObject3;
    }
    label316:
    label319:
    label352:
    for (;;)
    {
      paramContext.setOnClickListener(new SettingPermissionView..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(299055);
      return;
      break;
      break label217;
      localObject2 = this.mContext;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mContext");
        localObject1 = null;
      }
      localObject1 = (CharSequence)((Context)localObject1).getString(b.i.settings_permission_denied);
      break label271;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.view.SettingPermissionView
 * JD-Core Version:    0.7.0.1
 */