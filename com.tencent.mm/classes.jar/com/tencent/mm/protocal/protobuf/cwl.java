package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwl
  extends cvc
{
  public String FuL;
  public cwn Hol;
  public String Hom;
  public String Hon;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FuL != null) {
        paramVarArgs.d(2, this.FuL);
      }
      if (this.Hom != null) {
        paramVarArgs.d(3, this.Hom);
      }
      if (this.Hon != null) {
        paramVarArgs.d(4, this.Hon);
      }
      if (this.Hol != null)
      {
        paramVarArgs.lC(5, this.Hol.computeSize());
        this.Hol.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(181510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FuL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FuL);
      }
      i = paramInt;
      if (this.Hom != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hom);
      }
      paramInt = i;
      if (this.Hon != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hon);
      }
      i = paramInt;
      if (this.Hol != null) {
        i = paramInt + f.a.a.a.lB(5, this.Hol.computeSize());
      }
      AppMethodBeat.o(181510);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(181510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwl localcwl = (cwl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181510);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(181510);
          return 0;
        case 2: 
          localcwl.FuL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(181510);
          return 0;
        case 3: 
          localcwl.Hom = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(181510);
          return 0;
        case 4: 
          localcwl.Hon = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(181510);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcwl.Hol = ((cwn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(181510);
        return 0;
      }
      AppMethodBeat.o(181510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwl
 * JD-Core Version:    0.7.0.1
 */