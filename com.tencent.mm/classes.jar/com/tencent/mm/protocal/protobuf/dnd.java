package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnd
  extends com.tencent.mm.bx.a
{
  public String aaUm;
  public String aaUn;
  public String aaUo;
  public int aaUp;
  public String aaUq;
  public wg aaUr;
  public String aaUs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258656);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaUm != null) {
        paramVarArgs.g(1, this.aaUm);
      }
      if (this.aaUn != null) {
        paramVarArgs.g(2, this.aaUn);
      }
      if (this.aaUo != null) {
        paramVarArgs.g(3, this.aaUo);
      }
      paramVarArgs.bS(4, this.aaUp);
      if (this.aaUq != null) {
        paramVarArgs.g(5, this.aaUq);
      }
      if (this.aaUr != null)
      {
        paramVarArgs.qD(6, this.aaUr.computeSize());
        this.aaUr.writeFields(paramVarArgs);
      }
      if (this.aaUs != null) {
        paramVarArgs.g(7, this.aaUs);
      }
      AppMethodBeat.o(258656);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaUm == null) {
        break label632;
      }
    }
    label632:
    for (int i = i.a.a.b.b.a.h(1, this.aaUm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaUn != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaUn);
      }
      i = paramInt;
      if (this.aaUo != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaUo);
      }
      i += i.a.a.b.b.a.cJ(4, this.aaUp);
      paramInt = i;
      if (this.aaUq != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaUq);
      }
      i = paramInt;
      if (this.aaUr != null) {
        i = paramInt + i.a.a.a.qC(6, this.aaUr.computeSize());
      }
      paramInt = i;
      if (this.aaUs != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aaUs);
      }
      AppMethodBeat.o(258656);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258656);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dnd localdnd = (dnd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258656);
          return -1;
        case 1: 
          localdnd.aaUm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258656);
          return 0;
        case 2: 
          localdnd.aaUn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258656);
          return 0;
        case 3: 
          localdnd.aaUo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258656);
          return 0;
        case 4: 
          localdnd.aaUp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258656);
          return 0;
        case 5: 
          localdnd.aaUq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258656);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            wg localwg = new wg();
            if ((localObject != null) && (localObject.length > 0)) {
              localwg.parseFrom((byte[])localObject);
            }
            localdnd.aaUr = localwg;
            paramInt += 1;
          }
          AppMethodBeat.o(258656);
          return 0;
        }
        localdnd.aaUs = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258656);
        return 0;
      }
      AppMethodBeat.o(258656);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnd
 * JD-Core Version:    0.7.0.1
 */