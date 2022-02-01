package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awu
  extends dyl
{
  public int SJu;
  public String SJv;
  public LinkedList<Integer> SJw;
  public long commentId;
  public String objectNonceId;
  public int opType;
  public int scene;
  public String sessionBuffer;
  public String username;
  public long xaG;
  public long xbk;
  public int yBs;
  public aqe yjp;
  public int ziS;
  
  public awu()
  {
    AppMethodBeat.i(205925);
    this.SJw = new LinkedList();
    AppMethodBeat.o(205925);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169002);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.xbk);
      paramVarArgs.bm(3, this.commentId);
      paramVarArgs.aY(4, this.opType);
      paramVarArgs.bm(5, this.xaG);
      paramVarArgs.aY(6, this.SJu);
      if (this.username != null) {
        paramVarArgs.f(7, this.username);
      }
      paramVarArgs.aY(8, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.f(9, this.objectNonceId);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(10, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.f(11, this.sessionBuffer);
      }
      if (this.SJv != null) {
        paramVarArgs.f(12, this.SJv);
      }
      paramVarArgs.aY(13, this.yBs);
      paramVarArgs.aY(14, this.ziS);
      paramVarArgs.e(15, 2, this.SJw);
      AppMethodBeat.o(169002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1089;
      }
    }
    label1089:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.xbk) + g.a.a.b.b.a.p(3, this.commentId) + g.a.a.b.b.a.bM(4, this.opType) + g.a.a.b.b.a.p(5, this.xaG) + g.a.a.b.b.a.bM(6, this.SJu);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.username);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.objectNonceId);
      }
      i = paramInt;
      if (this.yjp != null) {
        i = paramInt + g.a.a.a.oD(10, this.yjp.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.sessionBuffer);
      }
      i = paramInt;
      if (this.SJv != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.SJv);
      }
      paramInt = g.a.a.b.b.a.bM(13, this.yBs);
      int j = g.a.a.b.b.a.bM(14, this.ziS);
      int k = g.a.a.a.c(15, 2, this.SJw);
      AppMethodBeat.o(169002);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SJw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169002);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        awu localawu = (awu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169002);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localawu.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 2: 
          localawu.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169002);
          return 0;
        case 3: 
          localawu.commentId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169002);
          return 0;
        case 4: 
          localawu.opType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169002);
          return 0;
        case 5: 
          localawu.xaG = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169002);
          return 0;
        case 6: 
          localawu.SJu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169002);
          return 0;
        case 7: 
          localawu.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 8: 
          localawu.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169002);
          return 0;
        case 9: 
          localawu.objectNonceId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localawu.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 11: 
          localawu.sessionBuffer = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 12: 
          localawu.SJv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 13: 
          localawu.yBs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169002);
          return 0;
        case 14: 
          localawu.ziS = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169002);
          return 0;
        }
        localawu.SJw.add(Integer.valueOf(((g.a.a.a.a)localObject1).abFh.AK()));
        AppMethodBeat.o(169002);
        return 0;
      }
      AppMethodBeat.o(169002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awu
 * JD-Core Version:    0.7.0.1
 */