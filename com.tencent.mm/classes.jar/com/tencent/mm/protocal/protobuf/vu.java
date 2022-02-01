package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vu
  extends com.tencent.mm.bx.a
{
  public String Zcq;
  public String Zcr;
  public String Zcs;
  public int Zct;
  public wg Zcu;
  public int Zcv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113953);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zcq != null) {
        paramVarArgs.g(1, this.Zcq);
      }
      if (this.Zcr != null) {
        paramVarArgs.g(2, this.Zcr);
      }
      if (this.Zcs != null) {
        paramVarArgs.g(3, this.Zcs);
      }
      paramVarArgs.bS(4, this.Zct);
      if (this.Zcu != null)
      {
        paramVarArgs.qD(5, this.Zcu.computeSize());
        this.Zcu.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.Zcv);
      AppMethodBeat.o(113953);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zcq == null) {
        break label556;
      }
    }
    label556:
    for (int i = i.a.a.b.b.a.h(1, this.Zcq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zcr != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zcr);
      }
      i = paramInt;
      if (this.Zcs != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zcs);
      }
      i += i.a.a.b.b.a.cJ(4, this.Zct);
      paramInt = i;
      if (this.Zcu != null) {
        paramInt = i + i.a.a.a.qC(5, this.Zcu.computeSize());
      }
      i = i.a.a.b.b.a.cJ(6, this.Zcv);
      AppMethodBeat.o(113953);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113953);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        vu localvu = (vu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113953);
          return -1;
        case 1: 
          localvu.Zcq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 2: 
          localvu.Zcr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 3: 
          localvu.Zcs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 4: 
          localvu.Zct = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(113953);
          return 0;
        case 5: 
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
            localvu.Zcu = localwg;
            paramInt += 1;
          }
          AppMethodBeat.o(113953);
          return 0;
        }
        localvu.Zcv = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(113953);
        return 0;
      }
      AppMethodBeat.o(113953);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vu
 * JD-Core Version:    0.7.0.1
 */