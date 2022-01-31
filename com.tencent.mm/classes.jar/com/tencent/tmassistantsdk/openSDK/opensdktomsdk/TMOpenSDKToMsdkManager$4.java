package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component.PopDialog;

class TMOpenSDKToMsdkManager$4
  implements View.OnClickListener
{
  TMOpenSDKToMsdkManager$4(TMOpenSDKToMsdkManager paramTMOpenSDKToMsdkManager) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(75923);
    if (this.this$0.mAuthorizedInfo == null)
    {
      AppMethodBeat.o(75923);
      return;
    }
    if (this.this$0.mContext != null) {
      this.this$0.getUserAuthorizedInfo(this.this$0.mAuthorizedInfo, this.this$0.mContext);
    }
    this.this$0.dialog.dismiss();
    AppMethodBeat.o(75923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.4
 * JD-Core Version:    0.7.0.1
 */