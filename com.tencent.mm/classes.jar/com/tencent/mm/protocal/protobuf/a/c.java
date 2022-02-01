package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public String ILh;
  public String Nickname;
  public b aciR;
  public d aciS;
  public String crB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259702);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aciR != null)
      {
        paramVarArgs.qD(1, this.aciR.computeSize());
        this.aciR.writeFields(paramVarArgs);
      }
      if (this.aciS != null)
      {
        paramVarArgs.qD(2, this.aciS.computeSize());
        this.aciS.writeFields(paramVarArgs);
      }
      if (this.ILh != null) {
        paramVarArgs.g(3, this.ILh);
      }
      if (this.Nickname != null) {
        paramVarArgs.g(4, this.Nickname);
      }
      if (this.crB != null) {
        paramVarArgs.g(5, this.crB);
      }
      AppMethodBeat.o(259702);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aciR == null) {
        break label598;
      }
    }
    label598:
    for (int i = i.a.a.a.qC(1, this.aciR.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aciS != null) {
        paramInt = i + i.a.a.a.qC(2, this.aciS.computeSize());
      }
      i = paramInt;
      if (this.ILh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ILh);
      }
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Nickname);
      }
      i = paramInt;
      if (this.crB != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.crB);
      }
      AppMethodBeat.o(259702);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259702);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259702);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new b();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((b)localObject2).parseFrom((byte[])localObject1);
            }
            localc.aciR = ((b)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259702);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new d();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((d)localObject2).parseFrom((byte[])localObject1);
            }
            localc.aciS = ((d)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259702);
          return 0;
        case 3: 
          localc.ILh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259702);
          return 0;
        case 4: 
          localc.Nickname = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259702);
          return 0;
        }
        localc.crB = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259702);
        return 0;
      }
      AppMethodBeat.o(259702);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.c
 * JD-Core Version:    0.7.0.1
 */