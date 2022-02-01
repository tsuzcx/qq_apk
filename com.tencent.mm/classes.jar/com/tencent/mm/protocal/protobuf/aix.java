package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aix
  extends cvw
{
  public String GyA;
  public long GyB;
  public double GyC;
  public double GyD;
  public String Gyz;
  public String eRf;
  public String eRg;
  public String qlv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.qlv != null) {
        paramVarArgs.d(2, this.qlv);
      }
      if (this.eRg != null) {
        paramVarArgs.d(3, this.eRg);
      }
      if (this.eRf != null) {
        paramVarArgs.d(4, this.eRf);
      }
      if (this.Gyz != null) {
        paramVarArgs.d(5, this.Gyz);
      }
      if (this.GyA != null) {
        paramVarArgs.d(6, this.GyA);
      }
      paramVarArgs.aZ(7, this.GyB);
      paramVarArgs.e(8, this.GyC);
      paramVarArgs.e(9, this.GyD);
      AppMethodBeat.o(91452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label752;
      }
    }
    label752:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qlv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qlv);
      }
      i = paramInt;
      if (this.eRg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.eRg);
      }
      paramInt = i;
      if (this.eRf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.eRf);
      }
      i = paramInt;
      if (this.Gyz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gyz);
      }
      paramInt = i;
      if (this.GyA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GyA);
      }
      i = f.a.a.b.b.a.p(7, this.GyB);
      int j = f.a.a.b.b.a.amD(8);
      int k = f.a.a.b.b.a.amD(9);
      AppMethodBeat.o(91452);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aix localaix = (aix)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91452);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaix.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91452);
          return 0;
        case 2: 
          localaix.qlv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 3: 
          localaix.eRg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 4: 
          localaix.eRf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 5: 
          localaix.Gyz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 6: 
          localaix.GyA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 7: 
          localaix.GyB = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91452);
          return 0;
        case 8: 
          localaix.GyC = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(91452);
          return 0;
        }
        localaix.GyD = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
        AppMethodBeat.o(91452);
        return 0;
      }
      AppMethodBeat.o(91452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aix
 * JD-Core Version:    0.7.0.1
 */