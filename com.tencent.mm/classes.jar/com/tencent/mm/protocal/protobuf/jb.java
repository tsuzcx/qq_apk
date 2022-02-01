package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class jb
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public gol YKQ;
  public String YKR;
  public int YKS;
  public String vgy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32135);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YKQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32135);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.Idd);
      if (this.YKQ != null)
      {
        paramVarArgs.qD(2, this.YKQ.computeSize());
        this.YKQ.writeFields(paramVarArgs);
      }
      if (this.YKR != null) {
        paramVarArgs.g(3, this.YKR);
      }
      paramVarArgs.bS(4, this.YKS);
      if (this.vgy != null) {
        paramVarArgs.g(5, this.vgy);
      }
      AppMethodBeat.o(32135);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Idd) + 0;
      paramInt = i;
      if (this.YKQ != null) {
        paramInt = i + i.a.a.a.qC(2, this.YKQ.computeSize());
      }
      i = paramInt;
      if (this.YKR != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YKR);
      }
      i += i.a.a.b.b.a.cJ(4, this.YKS);
      paramInt = i;
      if (this.vgy != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.vgy);
      }
      AppMethodBeat.o(32135);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.YKQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32135);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32135);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      jb localjb = (jb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32135);
        return -1;
      case 1: 
        localjb.Idd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32135);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gol localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localjb.YKQ = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(32135);
        return 0;
      case 3: 
        localjb.YKR = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32135);
        return 0;
      case 4: 
        localjb.YKS = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32135);
        return 0;
      }
      localjb.vgy = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(32135);
      return 0;
    }
    AppMethodBeat.o(32135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jb
 * JD-Core Version:    0.7.0.1
 */