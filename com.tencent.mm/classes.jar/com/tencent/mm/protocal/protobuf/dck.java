package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dck
  extends com.tencent.mm.bx.a
{
  public String aaIj;
  public String aaIk;
  public ajx aaIl;
  public ajx aaIm;
  public String aaIn;
  public String aaIo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72509);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaIj != null) {
        paramVarArgs.g(1, this.aaIj);
      }
      if (this.aaIk != null) {
        paramVarArgs.g(2, this.aaIk);
      }
      if (this.aaIl != null)
      {
        paramVarArgs.qD(3, this.aaIl.computeSize());
        this.aaIl.writeFields(paramVarArgs);
      }
      if (this.aaIm != null)
      {
        paramVarArgs.qD(4, this.aaIm.computeSize());
        this.aaIm.writeFields(paramVarArgs);
      }
      if (this.aaIn != null) {
        paramVarArgs.g(5, this.aaIn);
      }
      if (this.aaIo != null) {
        paramVarArgs.g(6, this.aaIo);
      }
      AppMethodBeat.o(72509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaIj == null) {
        break label658;
      }
    }
    label658:
    for (int i = i.a.a.b.b.a.h(1, this.aaIj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaIk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaIk);
      }
      i = paramInt;
      if (this.aaIl != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaIl.computeSize());
      }
      paramInt = i;
      if (this.aaIm != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaIm.computeSize());
      }
      i = paramInt;
      if (this.aaIn != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaIn);
      }
      paramInt = i;
      if (this.aaIo != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaIo);
      }
      AppMethodBeat.o(72509);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dck localdck = (dck)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        ajx localajx;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72509);
          return -1;
        case 1: 
          localdck.aaIj = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 2: 
          localdck.aaIk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localajx = new ajx();
            if ((localObject != null) && (localObject.length > 0)) {
              localajx.parseFrom((byte[])localObject);
            }
            localdck.aaIl = localajx;
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localajx = new ajx();
            if ((localObject != null) && (localObject.length > 0)) {
              localajx.parseFrom((byte[])localObject);
            }
            localdck.aaIm = localajx;
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 5: 
          localdck.aaIn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72509);
          return 0;
        }
        localdck.aaIo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72509);
        return 0;
      }
      AppMethodBeat.o(72509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dck
 * JD-Core Version:    0.7.0.1
 */