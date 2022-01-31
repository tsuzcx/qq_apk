package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajo
  extends com.tencent.mm.bv.a
{
  public int DesignerUin;
  public int OpCode;
  public int wQm;
  public SKBuiltinBuffer_t xaZ;
  public String xba;
  public int xbb;
  public long xbc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62548);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.OpCode);
      paramVarArgs.aO(2, this.DesignerUin);
      if (this.xaZ != null)
      {
        paramVarArgs.iQ(3, this.xaZ.computeSize());
        this.xaZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.wQm);
      if (this.xba != null) {
        paramVarArgs.e(5, this.xba);
      }
      paramVarArgs.aO(6, this.xbb);
      paramVarArgs.am(7, this.xbc);
      AppMethodBeat.o(62548);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.OpCode) + 0 + e.a.a.b.b.a.bl(2, this.DesignerUin);
      paramInt = i;
      if (this.xaZ != null) {
        paramInt = i + e.a.a.a.iP(3, this.xaZ.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.wQm);
      paramInt = i;
      if (this.xba != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xba);
      }
      i = e.a.a.b.b.a.bl(6, this.xbb);
      int j = e.a.a.b.b.a.p(7, this.xbc);
      AppMethodBeat.o(62548);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(62548);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      ajo localajo = (ajo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(62548);
        return -1;
      case 1: 
        localajo.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(62548);
        return 0;
      case 2: 
        localajo.DesignerUin = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(62548);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localajo.xaZ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(62548);
        return 0;
      case 4: 
        localajo.wQm = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(62548);
        return 0;
      case 5: 
        localajo.xba = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(62548);
        return 0;
      case 6: 
        localajo.xbb = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(62548);
        return 0;
      }
      localajo.xbc = ((e.a.a.a.a)localObject1).CLY.sm();
      AppMethodBeat.o(62548);
      return 0;
    }
    AppMethodBeat.o(62548);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajo
 * JD-Core Version:    0.7.0.1
 */