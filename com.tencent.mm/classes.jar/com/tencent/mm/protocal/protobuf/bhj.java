package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhj
  extends com.tencent.mm.bx.a
{
  public String DFk;
  public String DFo;
  public String DFp;
  public String DFq;
  public bxp DFr;
  public int dtb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72508);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DFk == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72508);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.dtb);
      if (this.DFk != null) {
        paramVarArgs.d(2, this.DFk);
      }
      if (this.DFo != null) {
        paramVarArgs.d(3, this.DFo);
      }
      if (this.DFp != null) {
        paramVarArgs.d(4, this.DFp);
      }
      if (this.DFq != null) {
        paramVarArgs.d(5, this.DFq);
      }
      if (this.DFr != null)
      {
        paramVarArgs.kX(6, this.DFr.computeSize());
        this.DFr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.dtb) + 0;
      paramInt = i;
      if (this.DFk != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DFk);
      }
      i = paramInt;
      if (this.DFo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DFo);
      }
      paramInt = i;
      if (this.DFp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DFp);
      }
      i = paramInt;
      if (this.DFq != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DFq);
      }
      paramInt = i;
      if (this.DFr != null) {
        paramInt = i + f.a.a.a.kW(6, this.DFr.computeSize());
      }
      AppMethodBeat.o(72508);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.DFk == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72508);
        throw paramVarArgs;
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bhj localbhj = (bhj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72508);
        return -1;
      case 1: 
        localbhj.dtb = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(72508);
        return 0;
      case 2: 
        localbhj.DFk = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 3: 
        localbhj.DFo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 4: 
        localbhj.DFp = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 5: 
        localbhj.DFq = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72508);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bxp();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bxp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbhj.DFr = ((bxp)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    AppMethodBeat.o(72508);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhj
 * JD-Core Version:    0.7.0.1
 */