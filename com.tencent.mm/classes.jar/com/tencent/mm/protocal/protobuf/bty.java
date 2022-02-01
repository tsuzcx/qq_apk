package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bty
  extends com.tencent.mm.bx.a
{
  public btx GOp;
  public bua GOq;
  public String Geb;
  public PersonalDesigner Gxo;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104818);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Geb != null) {
        paramVarArgs.d(1, this.Geb);
      }
      if (this.GOp != null)
      {
        paramVarArgs.lC(2, this.GOp.computeSize());
        this.GOp.writeFields(paramVarArgs);
      }
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.Gxo != null)
      {
        paramVarArgs.lC(4, this.Gxo.computeSize());
        this.Gxo.writeFields(paramVarArgs);
      }
      if (this.GOq != null)
      {
        paramVarArgs.lC(5, this.GOq.computeSize());
        this.GOq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104818);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Geb == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.b.b.a.e(1, this.Geb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GOp != null) {
        paramInt = i + f.a.a.a.lB(2, this.GOp.computeSize());
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Name);
      }
      paramInt = i;
      if (this.Gxo != null) {
        paramInt = i + f.a.a.a.lB(4, this.Gxo.computeSize());
      }
      i = paramInt;
      if (this.GOq != null) {
        i = paramInt + f.a.a.a.lB(5, this.GOq.computeSize());
      }
      AppMethodBeat.o(104818);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104818);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bty localbty = (bty)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104818);
          return -1;
        case 1: 
          localbty.Geb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbty.GOp = ((btx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        case 3: 
          localbty.Name = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new PersonalDesigner();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((PersonalDesigner)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbty.Gxo = ((PersonalDesigner)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bua();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bua)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbty.GOq = ((bua)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104818);
        return 0;
      }
      AppMethodBeat.o(104818);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bty
 * JD-Core Version:    0.7.0.1
 */