package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dbg
  extends com.tencent.mm.bx.a
{
  public String aaGH;
  public String aaGL;
  public String aaGM;
  public String aaGN;
  public dzy aaGO;
  public int hUR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72508);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaGH == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72508);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.hUR);
      if (this.aaGH != null) {
        paramVarArgs.g(2, this.aaGH);
      }
      if (this.aaGL != null) {
        paramVarArgs.g(3, this.aaGL);
      }
      if (this.aaGM != null) {
        paramVarArgs.g(4, this.aaGM);
      }
      if (this.aaGN != null) {
        paramVarArgs.g(5, this.aaGN);
      }
      if (this.aaGO != null)
      {
        paramVarArgs.qD(6, this.aaGO.computeSize());
        this.aaGO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.hUR) + 0;
      paramInt = i;
      if (this.aaGH != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaGH);
      }
      i = paramInt;
      if (this.aaGL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaGL);
      }
      paramInt = i;
      if (this.aaGM != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaGM);
      }
      i = paramInt;
      if (this.aaGN != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaGN);
      }
      paramInt = i;
      if (this.aaGO != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaGO.computeSize());
      }
      AppMethodBeat.o(72508);
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
      if (this.aaGH == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72508);
        throw paramVarArgs;
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dbg localdbg = (dbg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72508);
        return -1;
      case 1: 
        localdbg.hUR = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(72508);
        return 0;
      case 2: 
        localdbg.aaGH = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 3: 
        localdbg.aaGL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 4: 
        localdbg.aaGM = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 5: 
        localdbg.aaGN = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72508);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dzy localdzy = new dzy();
        if ((localObject != null) && (localObject.length > 0)) {
          localdzy.parseFrom((byte[])localObject);
        }
        localdbg.aaGO = localdzy;
        paramInt += 1;
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    AppMethodBeat.o(72508);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbg
 * JD-Core Version:    0.7.0.1
 */