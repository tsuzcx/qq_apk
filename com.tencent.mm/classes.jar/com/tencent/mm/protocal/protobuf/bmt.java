package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmt
  extends com.tencent.mm.bx.a
{
  public int Caa;
  public long DUP;
  public cr DUQ;
  public String DUR;
  public String DUS;
  public String DUT;
  public String desc;
  public String mdG;
  public int source;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258874);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.DUP);
      if (this.DUQ != null)
      {
        paramVarArgs.qD(2, this.DUQ.computeSize());
        this.DUQ.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      if (this.DUR != null) {
        paramVarArgs.g(4, this.DUR);
      }
      if (this.desc != null) {
        paramVarArgs.g(5, this.desc);
      }
      if (this.DUS != null) {
        paramVarArgs.g(6, this.DUS);
      }
      if (this.DUT != null) {
        paramVarArgs.g(7, this.DUT);
      }
      paramVarArgs.bS(8, this.Caa);
      if (this.mdG != null) {
        paramVarArgs.g(9, this.mdG);
      }
      paramVarArgs.bS(10, this.source);
      AppMethodBeat.o(258874);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.DUP) + 0;
      paramInt = i;
      if (this.DUQ != null) {
        paramInt = i + i.a.a.a.qC(2, this.DUQ.computeSize());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.title);
      }
      paramInt = i;
      if (this.DUR != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.DUR);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.desc);
      }
      paramInt = i;
      if (this.DUS != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.DUS);
      }
      i = paramInt;
      if (this.DUT != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.DUT);
      }
      i += i.a.a.b.b.a.cJ(8, this.Caa);
      paramInt = i;
      if (this.mdG != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.mdG);
      }
      i = i.a.a.b.b.a.cJ(10, this.source);
      AppMethodBeat.o(258874);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258874);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bmt localbmt = (bmt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258874);
        return -1;
      case 1: 
        localbmt.DUP = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258874);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cr localcr = new cr();
          if ((localObject != null) && (localObject.length > 0)) {
            localcr.parseFrom((byte[])localObject);
          }
          localbmt.DUQ = localcr;
          paramInt += 1;
        }
        AppMethodBeat.o(258874);
        return 0;
      case 3: 
        localbmt.title = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258874);
        return 0;
      case 4: 
        localbmt.DUR = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258874);
        return 0;
      case 5: 
        localbmt.desc = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258874);
        return 0;
      case 6: 
        localbmt.DUS = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258874);
        return 0;
      case 7: 
        localbmt.DUT = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258874);
        return 0;
      case 8: 
        localbmt.Caa = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258874);
        return 0;
      case 9: 
        localbmt.mdG = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258874);
        return 0;
      }
      localbmt.source = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(258874);
      return 0;
    }
    AppMethodBeat.o(258874);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmt
 * JD-Core Version:    0.7.0.1
 */