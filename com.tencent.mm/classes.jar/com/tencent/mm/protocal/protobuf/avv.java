package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class avv
  extends cvw
{
  public int FQm;
  public int FSu;
  public int FVa;
  public int GMY;
  public String GMZ;
  public LinkedList<avu> GNa;
  public LinkedList<b> GNb;
  public int Scene;
  public String oxI;
  
  public avv()
  {
    AppMethodBeat.i(152547);
    this.GNa = new LinkedList();
    this.GNb = new LinkedList();
    AppMethodBeat.o(152547);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152548);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FVa);
      paramVarArgs.aS(3, this.Scene);
      paramVarArgs.aS(4, this.FSu);
      paramVarArgs.aS(5, this.GMY);
      if (this.oxI != null) {
        paramVarArgs.d(6, this.oxI);
      }
      if (this.GMZ != null) {
        paramVarArgs.d(7, this.GMZ);
      }
      paramVarArgs.aS(8, this.FQm);
      paramVarArgs.e(9, 8, this.GNa);
      paramVarArgs.e(10, 6, this.GNb);
      AppMethodBeat.o(152548);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label858;
      }
    }
    label858:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FVa) + f.a.a.b.b.a.bz(3, this.Scene) + f.a.a.b.b.a.bz(4, this.FSu) + f.a.a.b.b.a.bz(5, this.GMY);
      paramInt = i;
      if (this.oxI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.oxI);
      }
      i = paramInt;
      if (this.GMZ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GMZ);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.FQm);
      int j = f.a.a.a.c(9, 8, this.GNa);
      int k = f.a.a.a.c(10, 6, this.GNb);
      AppMethodBeat.o(152548);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GNa.clear();
        this.GNb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152548);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avv localavv = (avv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152548);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        case 2: 
          localavv.FVa = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152548);
          return 0;
        case 3: 
          localavv.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152548);
          return 0;
        case 4: 
          localavv.FSu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152548);
          return 0;
        case 5: 
          localavv.GMY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152548);
          return 0;
        case 6: 
          localavv.oxI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 7: 
          localavv.GMZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 8: 
          localavv.FQm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152548);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavv.GNa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        }
        localavv.GNb.add(((f.a.a.a.a)localObject1).OmT.gCk());
        AppMethodBeat.o(152548);
        return 0;
      }
      AppMethodBeat.o(152548);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avv
 * JD-Core Version:    0.7.0.1
 */