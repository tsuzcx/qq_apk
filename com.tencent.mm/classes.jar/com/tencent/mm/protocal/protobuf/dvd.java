package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dvd
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int ID;
  public SKBuiltinBuffer_t IaO;
  public SKBuiltinBuffer_t IaP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32492);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IaO == null)
      {
        paramVarArgs = new b("Not all required fields were included: Icon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      if (this.IaP == null)
      {
        paramVarArgs = new b("Not all required fields were included: HDIcon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.ID);
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      if (this.IaO != null)
      {
        paramVarArgs.lJ(3, this.IaO.computeSize());
        this.IaO.writeFields(paramVarArgs);
      }
      if (this.IaP != null)
      {
        paramVarArgs.lJ(4, this.IaP.computeSize());
        this.IaP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.ID) + 0;
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Desc);
      }
      i = paramInt;
      if (this.IaO != null) {
        i = paramInt + f.a.a.a.lI(3, this.IaO.computeSize());
      }
      paramInt = i;
      if (this.IaP != null) {
        paramInt = i + f.a.a.a.lI(4, this.IaP.computeSize());
      }
      AppMethodBeat.o(32492);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.IaO == null)
      {
        paramVarArgs = new b("Not all required fields were included: Icon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      if (this.IaP == null)
      {
        paramVarArgs = new b("Not all required fields were included: HDIcon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dvd localdvd = (dvd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32492);
        return -1;
      case 1: 
        localdvd.ID = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32492);
        return 0;
      case 2: 
        localdvd.Desc = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32492);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdvd.IaO = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32492);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdvd.IaP = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    AppMethodBeat.o(32492);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvd
 * JD-Core Version:    0.7.0.1
 */