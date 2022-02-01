package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class jc
  extends com.tencent.mm.bx.a
  implements fcu
{
  public int Idd;
  public String YKP;
  public gol YKQ;
  public String YKR;
  public int YKS;
  public String YKT;
  public String YKU;
  public gol YKf;
  public String vgy;
  
  public final int getRet()
  {
    return this.Idd;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32136);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YKQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      if (this.YKf == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32136);
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
      if (this.YKf != null)
      {
        paramVarArgs.qD(4, this.YKf.computeSize());
        this.YKf.writeFields(paramVarArgs);
      }
      if (this.YKT != null) {
        paramVarArgs.g(5, this.YKT);
      }
      if (this.YKU != null) {
        paramVarArgs.g(6, this.YKU);
      }
      paramVarArgs.bS(7, this.YKS);
      if (this.vgy != null) {
        paramVarArgs.g(8, this.vgy);
      }
      if (this.YKP != null) {
        paramVarArgs.g(9, this.YKP);
      }
      AppMethodBeat.o(32136);
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
      paramInt = i;
      if (this.YKf != null) {
        paramInt = i + i.a.a.a.qC(4, this.YKf.computeSize());
      }
      i = paramInt;
      if (this.YKT != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YKT);
      }
      paramInt = i;
      if (this.YKU != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YKU);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.YKS);
      paramInt = i;
      if (this.vgy != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.vgy);
      }
      i = paramInt;
      if (this.YKP != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.YKP);
      }
      AppMethodBeat.o(32136);
      return i;
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
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      if (this.YKf == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32136);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      jc localjc = (jc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      gol localgol;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32136);
        return -1;
      case 1: 
        localjc.Idd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32136);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localjc.YKQ = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(32136);
        return 0;
      case 3: 
        localjc.YKR = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32136);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localjc.YKf = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(32136);
        return 0;
      case 5: 
        localjc.YKT = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32136);
        return 0;
      case 6: 
        localjc.YKU = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32136);
        return 0;
      case 7: 
        localjc.YKS = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32136);
        return 0;
      case 8: 
        localjc.vgy = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32136);
        return 0;
      }
      localjc.YKP = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(32136);
      return 0;
    }
    AppMethodBeat.o(32136);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jc
 * JD-Core Version:    0.7.0.1
 */