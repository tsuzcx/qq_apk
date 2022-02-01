package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class qq
  extends com.tencent.mm.bx.a
{
  public qs FMl;
  public cyt FMo;
  public qz FMp;
  public String nEt;
  public String ueY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117841);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nEt == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.FMo == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactItem");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.nEt != null) {
        paramVarArgs.d(1, this.nEt);
      }
      if (this.FMl != null)
      {
        paramVarArgs.lC(2, this.FMl.computeSize());
        this.FMl.writeFields(paramVarArgs);
      }
      if (this.FMo != null)
      {
        paramVarArgs.lC(3, this.FMo.computeSize());
        this.FMo.writeFields(paramVarArgs);
      }
      if (this.FMp != null)
      {
        paramVarArgs.lC(4, this.FMp.computeSize());
        this.FMp.writeFields(paramVarArgs);
      }
      if (this.ueY != null) {
        paramVarArgs.d(5, this.ueY);
      }
      AppMethodBeat.o(117841);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nEt == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.b.b.a.e(1, this.nEt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FMl != null) {
        paramInt = i + f.a.a.a.lB(2, this.FMl.computeSize());
      }
      i = paramInt;
      if (this.FMo != null) {
        i = paramInt + f.a.a.a.lB(3, this.FMo.computeSize());
      }
      paramInt = i;
      if (this.FMp != null) {
        paramInt = i + f.a.a.a.lB(4, this.FMp.computeSize());
      }
      i = paramInt;
      if (this.ueY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ueY);
      }
      AppMethodBeat.o(117841);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.nEt == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(117841);
          throw paramVarArgs;
        }
        if (this.FMo == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactItem");
          AppMethodBeat.o(117841);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117841);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qq localqq = (qq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117841);
          return -1;
        case 1: 
          localqq.nEt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117841);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqq.FMl = ((qs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqq.FMo = ((cyt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqq.FMp = ((qz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        }
        localqq.ueY = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117841);
        return 0;
      }
      AppMethodBeat.o(117841);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qq
 * JD-Core Version:    0.7.0.1
 */