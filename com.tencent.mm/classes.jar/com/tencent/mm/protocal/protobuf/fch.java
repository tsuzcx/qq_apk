package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fch
  extends com.tencent.mm.bx.a
{
  public fvv abBV;
  public String abBW;
  public String abBX;
  public String name;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259109);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.g(1, this.name);
      }
      if (this.value != null) {
        paramVarArgs.g(2, this.value);
      }
      if (this.abBV != null)
      {
        paramVarArgs.qD(3, this.abBV.computeSize());
        this.abBV.writeFields(paramVarArgs);
      }
      if (this.abBW != null) {
        paramVarArgs.g(4, this.abBW);
      }
      if (this.abBX != null) {
        paramVarArgs.g(5, this.abBX);
      }
      AppMethodBeat.o(259109);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label524;
      }
    }
    label524:
    for (int i = i.a.a.b.b.a.h(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.value != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.value);
      }
      i = paramInt;
      if (this.abBV != null) {
        i = paramInt + i.a.a.a.qC(3, this.abBV.computeSize());
      }
      paramInt = i;
      if (this.abBW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abBW);
      }
      i = paramInt;
      if (this.abBX != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abBX);
      }
      AppMethodBeat.o(259109);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259109);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fch localfch = (fch)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259109);
          return -1;
        case 1: 
          localfch.name = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259109);
          return 0;
        case 2: 
          localfch.value = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259109);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fvv localfvv = new fvv();
            if ((localObject != null) && (localObject.length > 0)) {
              localfvv.parseFrom((byte[])localObject);
            }
            localfch.abBV = localfvv;
            paramInt += 1;
          }
          AppMethodBeat.o(259109);
          return 0;
        case 4: 
          localfch.abBW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259109);
          return 0;
        }
        localfch.abBX = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259109);
        return 0;
      }
      AppMethodBeat.o(259109);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fch
 * JD-Core Version:    0.7.0.1
 */