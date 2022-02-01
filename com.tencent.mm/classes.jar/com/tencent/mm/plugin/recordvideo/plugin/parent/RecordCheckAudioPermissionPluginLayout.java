package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/RecordCheckAudioPermissionPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseScopePluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkAudioPermission", "", "getCheckAudioPermission", "()Z", "setCheckAudioPermission", "(Z)V", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "updateRecordTipByAudioPermission", "permission", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class RecordCheckAudioPermissionPluginLayout
  extends BaseScopePluginLayout
{
  public static final RecordCheckAudioPermissionPluginLayout.a NQz = new RecordCheckAudioPermissionPluginLayout.a((byte)0);
  private boolean GoP;
  
  public RecordCheckAudioPermissionPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static final void a(RecordCheckAudioPermissionPluginLayout paramRecordCheckAudioPermissionPluginLayout, DialogInterface paramDialogInterface, int paramInt)
  {
    s.u(paramRecordCheckAudioPermissionPluginLayout, "this$0");
    paramDialogInterface.dismiss();
    paramRecordCheckAudioPermissionPluginLayout.setCheckAudioPermission(true);
    paramRecordCheckAudioPermissionPluginLayout = paramRecordCheckAudioPermissionPluginLayout.getContext();
    if (paramRecordCheckAudioPermissionPluginLayout == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
    b.lx((Context)paramRecordCheckAudioPermissionPluginLayout);
  }
  
  private static final void b(RecordCheckAudioPermissionPluginLayout paramRecordCheckAudioPermissionPluginLayout, DialogInterface paramDialogInterface, int paramInt)
  {
    s.u(paramRecordCheckAudioPermissionPluginLayout, "this$0");
    paramDialogInterface.dismiss();
    paramRecordCheckAudioPermissionPluginLayout.tr(false);
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    s.u(parama, "navigator");
    s.u(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    eLi();
  }
  
  protected boolean eLi()
  {
    Context localContext = getContext();
    if (localContext == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
    boolean bool = b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 80, "");
    Log.i("MicroMsg.RecordCheckAudioPermissionPluginLayout", "checkAudioPermission " + bool + " !");
    return bool;
  }
  
  protected final boolean getCheckAudioPermission()
  {
    return this.GoP;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    Log.i("MicroMsg.RecordCheckAudioPermissionPluginLayout", "onRequestPermissionsResult requestCode:" + paramInt + " permissions:" + paramArrayOfString + " grantResults:" + paramArrayOfInt);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramInt == 80)
    {
      if (paramArrayOfInt.length != 0) {
        break label93;
      }
      paramInt = 1;
      if (paramInt != 0) {
        break label98;
      }
    }
    label93:
    label98:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
        break label103;
      }
      tr(true);
      return;
      paramInt = 0;
      break;
    }
    label103:
    k.a(getContext(), com.tencent.mm.cd.a.bt(getContext(), b.h.record_audio_permission_msg), com.tencent.mm.cd.a.bt(getContext(), b.h.record_audio_permission_title), com.tencent.mm.cd.a.bt(getContext(), b.h.record_audio_permission_require), com.tencent.mm.cd.a.bt(getContext(), b.h.record_audio_permission_gohead), false, new RecordCheckAudioPermissionPluginLayout..ExternalSyntheticLambda0(this), new RecordCheckAudioPermissionPluginLayout..ExternalSyntheticLambda1(this));
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.GoP)
    {
      Context localContext = getContext();
      if (localContext == null) {
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      }
      tr(b.g((Context)localContext, new String[] { "android.permission.RECORD_AUDIO" }));
    }
  }
  
  public final void setCheckAudioPermission(boolean paramBoolean)
  {
    this.GoP = paramBoolean;
  }
  
  public abstract void tr(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.RecordCheckAudioPermissionPluginLayout
 * JD-Core Version:    0.7.0.1
 */