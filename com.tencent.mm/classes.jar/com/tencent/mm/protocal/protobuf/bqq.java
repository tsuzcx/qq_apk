package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bqq
  extends dyl
{
  public int CPw;
  public eae RQU;
  public String RSB;
  public String TbJ;
  public int TbK;
  public b TbL;
  public String appid;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104367);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rWu);
      paramVarArgs.aY(3, this.CPw);
      if (this.TbJ != null) {
        paramVarArgs.f(4, this.TbJ);
      }
      if (this.RQU != null)
      {
        paramVarArgs.oE(5, this.RQU.computeSize());
        this.RQU.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.TbK);
      if (this.appid != null) {
        paramVarArgs.f(7, this.appid);
      }
      if (this.RSB != null) {
        paramVarArgs.f(8, this.RSB);
      }
      if (this.TbL != null) {
        paramVarArgs.c(9, this.TbL);
      }
      AppMethodBeat.o(104367);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWu) + g.a.a.b.b.a.bM(3, this.CPw);
      paramInt = i;
      if (this.TbJ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TbJ);
      }
      i = paramInt;
      if (this.RQU != null) {
        i = paramInt + g.a.a.a.oD(5, this.RQU.computeSize());
      }
      i += g.a.a.b.b.a.bM(6, this.TbK);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.appid);
      }
      i = paramInt;
      if (this.RSB != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.RSB);
      }
      paramInt = i;
      if (this.TbL != null) {
        paramInt = i + g.a.a.b.b.a.b(9, this.TbL);
      }
      AppMethodBeat.o(104367);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104367);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bqq localbqq = (bqq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104367);
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
            localbqq.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104367);
          return 0;
        case 2: 
          localbqq.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104367);
          return 0;
        case 3: 
          localbqq.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104367);
          return 0;
        case 4: 
          localbqq.TbJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104367);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localbqq.RQU = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104367);
          return 0;
        case 6: 
          localbqq.TbK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104367);
          return 0;
        case 7: 
          localbqq.appid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104367);
          return 0;
        case 8: 
          localbqq.RSB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104367);
          return 0;
        }
        localbqq.TbL = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(104367);
        return 0;
      }
      AppMethodBeat.o(104367);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqq
 * JD-Core Version:    0.7.0.1
 */