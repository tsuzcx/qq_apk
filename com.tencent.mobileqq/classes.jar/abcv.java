import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class abcv
  extends Handler
{
  boolean jdField_a_of_type_Boolean;
  
  abcv(abcr paramabcr) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while ((!(paramMessage.obj instanceof Bitmap)) || (this.jdField_a_of_type_Boolean));
            paramMessage = (Bitmap)paramMessage.obj;
          } while (paramMessage.isRecycled());
          paramMessage = nmb.a(paramMessage, (int)(34.0F * this.jdField_a_of_type_Abcr.jdField_a_of_type_Float));
        } while (this.jdField_a_of_type_Abcr.jdField_a_of_type_JavaLangRefWeakReference == null);
        localObject = (bhni)this.jdField_a_of_type_Abcr.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localObject != null) && ((localObject instanceof bhsx))) {
          ((bhsx)localObject).hideQQBrowserButton();
        }
        this.jdField_a_of_type_Abcr.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Abcr.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramMessage);
        if ((this.jdField_a_of_type_Abcr.jdField_a_of_type_AndroidAppActivity instanceof bhne))
        {
          paramMessage = ((bhne)this.jdField_a_of_type_Abcr.jdField_a_of_type_AndroidAppActivity).a();
          if ((paramMessage != null) && (paramMessage.mUIStyleHandler.b != null))
          {
            paramMessage.mUIStyleHandler.b.findViewById(2131366266).setVisibility(8);
            paramMessage.mUIStyleHandler.b.findViewById(2131366267).setVisibility(0);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d(abcr.jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity VISIBLE -----------------------");
      return;
    } while ((!(paramMessage.obj instanceof Bitmap)) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Abcr.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse == null) || (this.jdField_a_of_type_Abcr.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Abcr.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo.packName.get())));
    Object localObject = this.jdField_a_of_type_Abcr.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
    if (bgnw.a(this.jdField_a_of_type_Abcr.jdField_a_of_type_AndroidContentContext, ((GetAppInfoProto.AndroidInfo)localObject).packName.get())) {
      this.jdField_a_of_type_Abcr.b.setText(this.jdField_a_of_type_Abcr.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690052));
    }
    for (;;)
    {
      this.jdField_a_of_type_Abcr.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_Abcr.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690053), new Object[] { ((GetAppInfoProto.AndroidInfo)localObject).messagetail.get() }));
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage.isRecycled()) {
        break;
      }
      paramMessage = nmb.a(paramMessage, (int)(30.0F * this.jdField_a_of_type_Abcr.jdField_a_of_type_Float));
      this.jdField_a_of_type_Abcr.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Abcr.c.setImageBitmap(paramMessage);
      biur.a().a(this.jdField_a_of_type_Abcr.n, String.valueOf(bgkh.b(this.jdField_a_of_type_Abcr.jdField_a_of_type_Long)), "ANDROIDQQ.SHAREBAR", "100", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(abcr.jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity APP_FLOATING_BAR VISIBLE -----------------------");
      return;
      this.jdField_a_of_type_Abcr.b.setText(this.jdField_a_of_type_Abcr.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690051));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abcv
 * JD-Core Version:    0.7.0.1
 */