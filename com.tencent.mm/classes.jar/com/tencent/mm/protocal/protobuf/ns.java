package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ns
  extends cvw
{
  public LinkedList<String> Gav;
  public String Gaw;
  public double Gax;
  public double Gay;
  public String ProductID;
  public int Scene;
  
  public ns()
  {
    AppMethodBeat.i(124427);
    this.Gav = new LinkedList();
    AppMethodBeat.o(124427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(2, this.ProductID);
      }
      paramVarArgs.e(3, 1, this.Gav);
      paramVarArgs.aS(4, this.Scene);
      if (this.Gaw != null) {
        paramVarArgs.d(5, this.Gaw);
      }
      paramVarArgs.e(6, this.Gax);
      paramVarArgs.e(7, this.Gay);
      AppMethodBeat.o(124428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ProductID);
      }
      i = i + f.a.a.a.c(3, 1, this.Gav) + f.a.a.b.b.a.bz(4, this.Scene);
      paramInt = i;
      if (this.Gaw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gaw);
      }
      i = f.a.a.b.b.a.amD(6);
      int j = f.a.a.b.b.a.amD(7);
      AppMethodBeat.o(124428);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gav.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ns localns = (ns)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124428);
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
            localns.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124428);
          return 0;
        case 2: 
          localns.ProductID = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 3: 
          localns.Gav.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(124428);
          return 0;
        case 4: 
          localns.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124428);
          return 0;
        case 5: 
          localns.Gaw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 6: 
          localns.Gax = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(124428);
          return 0;
        }
        localns.Gay = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
        AppMethodBeat.o(124428);
        return 0;
      }
      AppMethodBeat.o(124428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ns
 * JD-Core Version:    0.7.0.1
 */