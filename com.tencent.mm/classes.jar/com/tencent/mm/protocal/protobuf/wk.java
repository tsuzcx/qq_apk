package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wk
  extends com.tencent.mm.bx.a
{
  public String Zdp;
  public String Zdq;
  public String Zdr;
  public int Zds;
  public String Zdt;
  public wg Zdu;
  public String Zdv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113968);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zdp != null) {
        paramVarArgs.g(1, this.Zdp);
      }
      if (this.Zdq != null) {
        paramVarArgs.g(2, this.Zdq);
      }
      if (this.Zdr != null) {
        paramVarArgs.g(3, this.Zdr);
      }
      paramVarArgs.bS(4, this.Zds);
      if (this.Zdt != null) {
        paramVarArgs.g(5, this.Zdt);
      }
      if (this.Zdu != null)
      {
        paramVarArgs.qD(6, this.Zdu.computeSize());
        this.Zdu.writeFields(paramVarArgs);
      }
      if (this.Zdv != null) {
        paramVarArgs.g(7, this.Zdv);
      }
      AppMethodBeat.o(113968);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zdp == null) {
        break label632;
      }
    }
    label632:
    for (int i = i.a.a.b.b.a.h(1, this.Zdp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zdq != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zdq);
      }
      i = paramInt;
      if (this.Zdr != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zdr);
      }
      i += i.a.a.b.b.a.cJ(4, this.Zds);
      paramInt = i;
      if (this.Zdt != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Zdt);
      }
      i = paramInt;
      if (this.Zdu != null) {
        i = paramInt + i.a.a.a.qC(6, this.Zdu.computeSize());
      }
      paramInt = i;
      if (this.Zdv != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Zdv);
      }
      AppMethodBeat.o(113968);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113968);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        wk localwk = (wk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113968);
          return -1;
        case 1: 
          localwk.Zdp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 2: 
          localwk.Zdq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 3: 
          localwk.Zdr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 4: 
          localwk.Zds = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(113968);
          return 0;
        case 5: 
          localwk.Zdt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113968);
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
            localwk.Zdu = localwg;
            paramInt += 1;
          }
          AppMethodBeat.o(113968);
          return 0;
        }
        localwk.Zdv = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(113968);
        return 0;
      }
      AppMethodBeat.o(113968);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wk
 * JD-Core Version:    0.7.0.1
 */