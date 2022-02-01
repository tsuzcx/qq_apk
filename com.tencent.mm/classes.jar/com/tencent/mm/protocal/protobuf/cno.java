package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cno
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t Dta;
  public String Dtb;
  public long Dtd;
  public int ReqType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104834);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dtb == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(104834);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.ReqType);
      if (this.Dtb != null) {
        paramVarArgs.d(2, this.Dtb);
      }
      if (this.Dta != null)
      {
        paramVarArgs.kX(3, this.Dta.computeSize());
        this.Dta.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(4, this.Dtd);
      AppMethodBeat.o(104834);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.ReqType) + 0;
      paramInt = i;
      if (this.Dtb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dtb);
      }
      i = paramInt;
      if (this.Dta != null) {
        i = paramInt + f.a.a.a.kW(3, this.Dta.computeSize());
      }
      paramInt = f.a.a.b.b.a.q(4, this.Dtd);
      AppMethodBeat.o(104834);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Dtb == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(104834);
        throw paramVarArgs;
      }
      AppMethodBeat.o(104834);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cno localcno = (cno)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104834);
        return -1;
      case 1: 
        localcno.ReqType = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(104834);
        return 0;
      case 2: 
        localcno.Dtb = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(104834);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcno.Dta = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104834);
        return 0;
      }
      localcno.Dtd = ((f.a.a.a.a)localObject1).KhF.xT();
      AppMethodBeat.o(104834);
      return 0;
    }
    AppMethodBeat.o(104834);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cno
 * JD-Core Version:    0.7.0.1
 */