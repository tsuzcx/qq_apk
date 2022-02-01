import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class afrg
  extends aniz
{
  public afrg(VisitorsActivity paramVisitorsActivity) {}
  
  protected void onFavoritorsList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("VisitorsActivity", 2, "onFavoritorsList.isSuccess=" + paramBoolean + ";uin=" + paramString + ";startMid=" + paramLong1 + ";nextMid=" + paramLong2);
      if (paramArrayList != null) {
        QLog.d("VisitorsActivity", 2, "onFavoritorsList.voters.size=" + paramArrayList.size());
      }
    }
    if (!this.a.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      paramString = this.a.jdField_b_of_type_JavaUtilArrayList;
      if (this.a.jdField_b_of_type_Boolean) {
        paramString = new ArrayList();
      }
      this.a.jdField_b_of_type_Long = paramLong2;
      paramArrayOfByte = this.a.jdField_b_of_type_Afrz;
      if (this.a.jdField_b_of_type_Long != -1L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramArrayOfByte.a(paramBoolean);
        paramArrayOfByte = paramString;
        if (paramArrayList != null) {
          paramArrayOfByte = bbyl.a(paramString, paramArrayList);
        }
        this.a.b(paramArrayOfByte, paramLong1);
        return;
      }
    }
    this.a.d();
  }
  
  protected void onGetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "onGetPartakeLikeRankingList.isSuccess=" + paramBoolean1 + ";isOn=" + paramBoolean2);
    }
    if (paramBoolean1) {
      this.a.a(paramBoolean2);
    }
  }
  
  protected void onReqDelVoteRecord(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity", 2, String.format("onReqDelVoteRecord selfUin:%s targetUin:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) }));
    }
    if (paramLong1 != Long.parseLong(this.a.app.getCurrentAccountUin())) {}
    while (paramBoolean) {
      return;
    }
    this.a.a(1, anni.a(2131715484));
  }
  
  protected void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramString1.equals(this.a.app.getCurrentAccountUin())) {}
    do
    {
      return;
      if (paramInt2 == 1)
      {
        if (!paramBoolean)
        {
          this.a.jdField_a_of_type_Azkn.b(paramString2, paramInt1, true);
          return;
        }
        this.a.jdField_a_of_type_Azkn.a(paramString2, paramInt1, true);
        return;
      }
    } while (paramInt2 != 0);
    this.a.jdField_a_of_type_Azkn.a(Long.parseLong(paramString2));
  }
  
  protected void onSetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "onSetPartakeLikeRankingList.isSuccess=" + paramBoolean1 + ";isOn=" + paramBoolean2);
    }
    if (paramBoolean1) {
      this.a.a(paramBoolean2);
    }
  }
  
  protected void onVoterList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, ArrayList<Long> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("VisitorsActivity", 2, "onVoterList.isSuccess=" + paramBoolean + ";uin=" + paramString + ";startMid=" + paramLong1 + ";nextMid=" + paramLong2 + "todayVoteCount=" + paramInt3 + "todayVoteRank=" + paramInt4 + "totalVoteCount=" + paramInt5);
      if (paramArrayList != null) {
        QLog.d("VisitorsActivity", 2, "onVoterList.voters.size=" + paramArrayList.size());
      }
    }
    if (!this.a.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Azkn.a(paramArrayList1, paramInt1, paramInt2, paramLong1);
      paramString = this.a.jdField_a_of_type_JavaUtilArrayList;
      if (this.a.jdField_a_of_type_Boolean)
      {
        this.a.app.a().c(anhk.E, 1001);
        this.a.app.a().c(anhk.E, 10002);
        paramString = new ArrayList();
      }
      this.a.jdField_a_of_type_Long = paramLong2;
      paramArrayList1 = this.a.jdField_a_of_type_Afrz;
      if (this.a.jdField_a_of_type_Long != -1L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramArrayList1.a(paramBoolean);
        paramArrayList1 = paramString;
        if (paramArrayList != null) {
          paramArrayList1 = bbyl.a(paramString, paramArrayList);
        }
        this.a.a(paramArrayList1, paramLong1);
        this.a.a(paramInt3, paramInt4, paramInt5);
        return;
      }
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrg
 * JD-Core Version:    0.7.0.1
 */