package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ena
  extends com.tencent.mm.bx.a
{
  public akj YUs;
  public int abrm;
  public int abrn;
  public String abro;
  public String igg;
  public String wording;
  public String xml;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260150);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.xml != null) {
        paramVarArgs.g(1, this.xml);
      }
      paramVarArgs.bS(2, this.abrm);
      paramVarArgs.bS(3, this.abrn);
      if (this.abro != null) {
        paramVarArgs.g(4, this.abro);
      }
      if (this.wording != null) {
        paramVarArgs.g(5, this.wording);
      }
      if (this.igg != null) {
        paramVarArgs.g(6, this.igg);
      }
      if (this.YUs != null)
      {
        paramVarArgs.qD(7, this.YUs.computeSize());
        this.YUs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260150);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xml == null) {
        break label616;
      }
    }
    label616:
    for (paramInt = i.a.a.b.b.a.h(1, this.xml) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abrm) + i.a.a.b.b.a.cJ(3, this.abrn);
      paramInt = i;
      if (this.abro != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abro);
      }
      i = paramInt;
      if (this.wording != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.wording);
      }
      paramInt = i;
      if (this.igg != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.igg);
      }
      i = paramInt;
      if (this.YUs != null) {
        i = paramInt + i.a.a.a.qC(7, this.YUs.computeSize());
      }
      AppMethodBeat.o(260150);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260150);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ena localena = (ena)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260150);
          return -1;
        case 1: 
          localena.xml = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260150);
          return 0;
        case 2: 
          localena.abrm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(260150);
          return 0;
        case 3: 
          localena.abrn = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(260150);
          return 0;
        case 4: 
          localena.abro = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260150);
          return 0;
        case 5: 
          localena.wording = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260150);
          return 0;
        case 6: 
          localena.igg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260150);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          akj localakj = new akj();
          if ((localObject != null) && (localObject.length > 0)) {
            localakj.parseFrom((byte[])localObject);
          }
          localena.YUs = localakj;
          paramInt += 1;
        }
        AppMethodBeat.o(260150);
        return 0;
      }
      AppMethodBeat.o(260150);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ena
 * JD-Core Version:    0.7.0.1
 */