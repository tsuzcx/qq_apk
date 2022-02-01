package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejv
  extends com.tencent.mm.cd.a
{
  public int INC;
  public int LcN;
  public LinkedList<aox> UlL;
  public long UlM;
  public double UlN;
  public double UlO;
  public int bFP;
  public int commentCount;
  public boolean dic;
  public long endTime;
  public String feedId;
  public int height;
  public boolean isAd;
  public int likeCount;
  public String nickName;
  public int pEk;
  public long startTime;
  public String userName;
  public int virtualKeyHeight;
  public int xRu;
  public int y;
  
  public ejv()
  {
    AppMethodBeat.i(122546);
    this.y = -1;
    this.height = -1;
    this.pEk = -1;
    this.virtualKeyHeight = 0;
    this.INC = -1;
    this.xRu = -1;
    this.bFP = 0;
    this.LcN = 0;
    this.dic = false;
    this.startTime = -1L;
    this.endTime = -1L;
    this.UlL = new LinkedList();
    this.UlM = 0L;
    this.UlN = 0.0D;
    this.UlO = 0.0D;
    this.isAd = false;
    AppMethodBeat.o(122546);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122547);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.feedId != null) {
        paramVarArgs.f(1, this.feedId);
      }
      paramVarArgs.aY(2, this.y);
      paramVarArgs.aY(3, this.height);
      paramVarArgs.aY(4, this.pEk);
      paramVarArgs.aY(5, this.virtualKeyHeight);
      paramVarArgs.aY(6, this.INC);
      paramVarArgs.aY(7, this.xRu);
      paramVarArgs.aY(8, this.bFP);
      paramVarArgs.aY(9, this.LcN);
      paramVarArgs.co(10, this.dic);
      paramVarArgs.bm(11, this.startTime);
      paramVarArgs.bm(12, this.endTime);
      paramVarArgs.e(13, 8, this.UlL);
      paramVarArgs.bm(14, this.UlM);
      paramVarArgs.e(15, this.UlN);
      paramVarArgs.e(16, this.UlO);
      paramVarArgs.aY(17, this.commentCount);
      paramVarArgs.aY(18, this.likeCount);
      if (this.userName != null) {
        paramVarArgs.f(19, this.userName);
      }
      paramVarArgs.co(20, this.isAd);
      if (this.nickName != null) {
        paramVarArgs.f(21, this.nickName);
      }
      AppMethodBeat.o(122547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.feedId == null) {
        break label1202;
      }
    }
    label1202:
    for (paramInt = g.a.a.b.b.a.g(1, this.feedId) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.y) + g.a.a.b.b.a.bM(3, this.height) + g.a.a.b.b.a.bM(4, this.pEk) + g.a.a.b.b.a.bM(5, this.virtualKeyHeight) + g.a.a.b.b.a.bM(6, this.INC) + g.a.a.b.b.a.bM(7, this.xRu) + g.a.a.b.b.a.bM(8, this.bFP) + g.a.a.b.b.a.bM(9, this.LcN) + (g.a.a.b.b.a.gL(10) + 1) + g.a.a.b.b.a.p(11, this.startTime) + g.a.a.b.b.a.p(12, this.endTime) + g.a.a.a.c(13, 8, this.UlL) + g.a.a.b.b.a.p(14, this.UlM) + (g.a.a.b.b.a.gL(15) + 8) + (g.a.a.b.b.a.gL(16) + 8) + g.a.a.b.b.a.bM(17, this.commentCount) + g.a.a.b.b.a.bM(18, this.likeCount);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.userName);
      }
      i = paramInt + (g.a.a.b.b.a.gL(20) + 1);
      paramInt = i;
      if (this.nickName != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.nickName);
      }
      AppMethodBeat.o(122547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UlL.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122547);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ejv localejv = (ejv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122547);
          return -1;
        case 1: 
          localejv.feedId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 2: 
          localejv.y = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122547);
          return 0;
        case 3: 
          localejv.height = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122547);
          return 0;
        case 4: 
          localejv.pEk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122547);
          return 0;
        case 5: 
          localejv.virtualKeyHeight = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122547);
          return 0;
        case 6: 
          localejv.INC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122547);
          return 0;
        case 7: 
          localejv.xRu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122547);
          return 0;
        case 8: 
          localejv.bFP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122547);
          return 0;
        case 9: 
          localejv.LcN = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122547);
          return 0;
        case 10: 
          localejv.dic = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(122547);
          return 0;
        case 11: 
          localejv.startTime = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(122547);
          return 0;
        case 12: 
          localejv.endTime = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(122547);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aox localaox = new aox();
            if ((localObject != null) && (localObject.length > 0)) {
              localaox.parseFrom((byte[])localObject);
            }
            localejv.UlL.add(localaox);
            paramInt += 1;
          }
          AppMethodBeat.o(122547);
          return 0;
        case 14: 
          localejv.UlM = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(122547);
          return 0;
        case 15: 
          localejv.UlN = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(122547);
          return 0;
        case 16: 
          localejv.UlO = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(122547);
          return 0;
        case 17: 
          localejv.commentCount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122547);
          return 0;
        case 18: 
          localejv.likeCount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122547);
          return 0;
        case 19: 
          localejv.userName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 20: 
          localejv.isAd = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(122547);
          return 0;
        }
        localejv.nickName = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(122547);
        return 0;
      }
      AppMethodBeat.o(122547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejv
 * JD-Core Version:    0.7.0.1
 */