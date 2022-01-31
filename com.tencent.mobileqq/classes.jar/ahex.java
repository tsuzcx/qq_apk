import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;

public abstract class ahex
{
  public ahes a;
  protected ahfa a;
  protected ambh a;
  private ameq jdField_a_of_type_Ameq = new ahez(this);
  protected Context a;
  protected TextView a;
  private bhtv jdField_a_of_type_Bhtv = new ahey(this);
  protected QQAppInterface a;
  protected XListView a;
  public boolean a;
  protected boolean b = true;
  protected boolean c = true;
  
  public ahex()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public ahex(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, ahfa paramahfa)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Ahfa = paramahfa;
    a();
  }
  
  private void f()
  {
    g();
    this.jdField_a_of_type_Ahes = a();
    this.jdField_a_of_type_Ahes.a(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahes);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    if (this.c) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_Bhtv);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131713653));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    int i = aepi.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, i, i, i);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166981));
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private void h()
  {
    c();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (a()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131713654));
    }
  }
  
  protected abstract ahes a();
  
  public XListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  protected oidb_0x935.GPS a()
  {
    Object localObject = ampk.a("recommend_troop");
    double d1;
    int k;
    double d2;
    String str;
    int i;
    if (localObject != null)
    {
      d1 = ((SosoInterface.SosoLbsInfo)localObject).a.e;
      k = (int)((SosoInterface.SosoLbsInfo)localObject).a.jdField_a_of_type_Float;
      d2 = ((SosoInterface.SosoLbsInfo)localObject).a.jdField_a_of_type_Long;
      str = ((SosoInterface.SosoLbsInfo)localObject).a.f;
      i = 0;
    }
    try
    {
      int j = Integer.parseInt(str);
      i = j;
    }
    catch (Exception localException)
    {
      label66:
      double d3;
      double d4;
      break label66;
    }
    d3 = Double.valueOf(((SosoInterface.SosoLbsInfo)localObject).a.jdField_a_of_type_Double * 1000000.0D).intValue();
    d4 = Double.valueOf(((SosoInterface.SosoLbsInfo)localObject).a.b * 1000000.0D).intValue();
    localObject = new oidb_0x935.GPS();
    ((oidb_0x935.GPS)localObject).uint32_latitude.set((int)d3);
    ((oidb_0x935.GPS)localObject).uint32_longitude.set((int)d4);
    ((oidb_0x935.GPS)localObject).uint32_altitude.set((int)d1);
    ((oidb_0x935.GPS)localObject).uint32_accuracy.set(k);
    ((oidb_0x935.GPS)localObject).uint32_time.set((int)d2);
    ((oidb_0x935.GPS)localObject).uint32_cityid.set(i);
    ((oidb_0x935.GPS)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.3.5"));
    ((oidb_0x935.GPS)localObject).uint32_client.set(2);
    return localObject;
    return null;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
      this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_Ambh = ((ambh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(22));
    f();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ameq);
    if ((this.jdField_a_of_type_Boolean) && (this.b)) {
      a(false);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ambh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), a());
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList) {}
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Ambh.a == 1;
  }
  
  public void b()
  {
    a(false);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      h();
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Ahes.a(this.jdField_a_of_type_Ambh.b);
    this.jdField_a_of_type_Ahes.notifyDataSetChanged();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopListWrapper", 2, "checkAndLoadMoreRecommList isEnd = " + a());
    }
    if (!a()) {
      a(true);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ameq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahex
 * JD-Core Version:    0.7.0.1
 */