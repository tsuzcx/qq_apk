package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class geo
  extends com.tencent.mm.bx.a
{
  public int abaE;
  public String absh;
  public gep acca;
  public String accb;
  public String accc;
  public String accd;
  public String acce;
  public String accf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259762);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abaE);
      if (this.acca != null)
      {
        paramVarArgs.qD(2, this.acca.computeSize());
        this.acca.writeFields(paramVarArgs);
      }
      if (this.absh != null) {
        paramVarArgs.g(3, this.absh);
      }
      if (this.accb != null) {
        paramVarArgs.g(4, this.accb);
      }
      if (this.accc != null) {
        paramVarArgs.g(5, this.accc);
      }
      if (this.accd != null) {
        paramVarArgs.g(6, this.accd);
      }
      if (this.acce != null) {
        paramVarArgs.g(7, this.acce);
      }
      if (this.accf != null) {
        paramVarArgs.g(8, this.accf);
      }
      AppMethodBeat.o(259762);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abaE) + 0;
      paramInt = i;
      if (this.acca != null) {
        paramInt = i + i.a.a.a.qC(2, this.acca.computeSize());
      }
      i = paramInt;
      if (this.absh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.absh);
      }
      paramInt = i;
      if (this.accb != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.accb);
      }
      i = paramInt;
      if (this.accc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.accc);
      }
      paramInt = i;
      if (this.accd != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.accd);
      }
      i = paramInt;
      if (this.acce != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.acce);
      }
      paramInt = i;
      if (this.accf != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.accf);
      }
      AppMethodBeat.o(259762);
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
      AppMethodBeat.o(259762);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      geo localgeo = (geo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259762);
        return -1;
      case 1: 
        localgeo.abaE = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259762);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gep localgep = new gep();
          if ((localObject != null) && (localObject.length > 0)) {
            localgep.parseFrom((byte[])localObject);
          }
          localgeo.acca = localgep;
          paramInt += 1;
        }
        AppMethodBeat.o(259762);
        return 0;
      case 3: 
        localgeo.absh = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259762);
        return 0;
      case 4: 
        localgeo.accb = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259762);
        return 0;
      case 5: 
        localgeo.accc = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259762);
        return 0;
      case 6: 
        localgeo.accd = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259762);
        return 0;
      case 7: 
        localgeo.acce = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259762);
        return 0;
      }
      localgeo.accf = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(259762);
      return 0;
    }
    AppMethodBeat.o(259762);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.geo
 * JD-Core Version:    0.7.0.1
 */