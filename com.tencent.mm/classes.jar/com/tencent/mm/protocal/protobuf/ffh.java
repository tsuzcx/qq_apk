package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ffh
  extends dyl
{
  public int SfH;
  public eae SfI;
  public int Svu;
  public long Svv;
  public String TWw;
  public long UCJ;
  public fdy UFU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115925);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SfI == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(115925);
        throw paramVarArgs;
      }
      if (this.UFU == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpLog");
        AppMethodBeat.o(115925);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TWw != null) {
        paramVarArgs.f(2, this.TWw);
      }
      paramVarArgs.aY(3, this.Svu);
      if (this.SfI != null)
      {
        paramVarArgs.oE(4, this.SfI.computeSize());
        this.SfI.writeFields(paramVarArgs);
      }
      if (this.UFU != null)
      {
        paramVarArgs.oE(5, this.UFU.computeSize());
        this.UFU.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.Svv);
      paramVarArgs.aY(7, this.SfH);
      paramVarArgs.bm(8, this.UCJ);
      AppMethodBeat.o(115925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label896;
      }
    }
    label896:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TWw != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TWw);
      }
      i += g.a.a.b.b.a.bM(3, this.Svu);
      paramInt = i;
      if (this.SfI != null) {
        paramInt = i + g.a.a.a.oD(4, this.SfI.computeSize());
      }
      i = paramInt;
      if (this.UFU != null) {
        i = paramInt + g.a.a.a.oD(5, this.UFU.computeSize());
      }
      paramInt = g.a.a.b.b.a.p(6, this.Svv);
      int j = g.a.a.b.b.a.bM(7, this.SfH);
      int k = g.a.a.b.b.a.p(8, this.UCJ);
      AppMethodBeat.o(115925);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SfI == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        if (this.UFU == null)
        {
          paramVarArgs = new b("Not all required fields were included: OpLog");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ffh localffh = (ffh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115925);
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
            localffh.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 2: 
          localffh.TWw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(115925);
          return 0;
        case 3: 
          localffh.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115925);
          return 0;
        case 4: 
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
            localffh.SfI = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fdy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fdy)localObject2).parseFrom((byte[])localObject1);
            }
            localffh.UFU = ((fdy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 6: 
          localffh.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115925);
          return 0;
        case 7: 
          localffh.SfH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115925);
          return 0;
        }
        localffh.UCJ = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(115925);
        return 0;
      }
      AppMethodBeat.o(115925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffh
 * JD-Core Version:    0.7.0.1
 */