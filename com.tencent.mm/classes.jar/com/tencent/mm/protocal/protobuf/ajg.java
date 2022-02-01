package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ajg
  extends dyl
{
  public String RMJ;
  public int RNt;
  public eae RQU;
  public String RQx;
  public String RRg;
  public String StK;
  public String StL;
  public int StM;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155402);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RQU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(155402);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RQU != null)
      {
        paramVarArgs.oE(2, this.RQU.computeSize());
        this.RQU.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.RNt);
      if (this.RQx != null) {
        paramVarArgs.f(4, this.RQx);
      }
      if (this.vhq != null) {
        paramVarArgs.f(5, this.vhq);
      }
      if (this.RRg != null) {
        paramVarArgs.f(6, this.RRg);
      }
      if (this.StK != null) {
        paramVarArgs.f(7, this.StK);
      }
      if (this.RMJ != null) {
        paramVarArgs.f(8, this.RMJ);
      }
      if (this.StL != null) {
        paramVarArgs.f(9, this.StL);
      }
      paramVarArgs.aY(10, this.StM);
      AppMethodBeat.o(155402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RQU != null) {
        i = paramInt + g.a.a.a.oD(2, this.RQU.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.RNt);
      paramInt = i;
      if (this.RQx != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RQx);
      }
      i = paramInt;
      if (this.vhq != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.vhq);
      }
      paramInt = i;
      if (this.RRg != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RRg);
      }
      i = paramInt;
      if (this.StK != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.StK);
      }
      paramInt = i;
      if (this.RMJ != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RMJ);
      }
      i = paramInt;
      if (this.StL != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.StL);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.StM);
      AppMethodBeat.o(155402);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RQU == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(155402);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ajg localajg = (ajg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155402);
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
            localajg.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155402);
          return 0;
        case 2: 
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
            localajg.RQU = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155402);
          return 0;
        case 3: 
          localajg.RNt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155402);
          return 0;
        case 4: 
          localajg.RQx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 5: 
          localajg.vhq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 6: 
          localajg.RRg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 7: 
          localajg.StK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 8: 
          localajg.RMJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 9: 
          localajg.StL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155402);
          return 0;
        }
        localajg.StM = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(155402);
        return 0;
      }
      AppMethodBeat.o(155402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajg
 * JD-Core Version:    0.7.0.1
 */