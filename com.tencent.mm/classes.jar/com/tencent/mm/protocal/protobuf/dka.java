package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dka
  extends com.tencent.mm.cd.a
{
  public String ODt;
  public String Ooe;
  public String Oof;
  public dvi TRC;
  public String desc;
  public int jump_type;
  public String llI;
  public String name;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72542);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.f(1, this.name);
      }
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(3, this.desc);
      }
      if (this.llI != null) {
        paramVarArgs.f(4, this.llI);
      }
      paramVarArgs.aY(5, this.jump_type);
      if (this.ODt != null) {
        paramVarArgs.f(6, this.ODt);
      }
      if (this.Ooe != null) {
        paramVarArgs.f(7, this.Ooe);
      }
      if (this.Oof != null) {
        paramVarArgs.f(8, this.Oof);
      }
      if (this.TRC != null)
      {
        paramVarArgs.oE(9, this.TRC.computeSize());
        this.TRC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label760;
      }
    }
    label760:
    for (int i = g.a.a.b.b.a.g(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.desc);
      }
      paramInt = i;
      if (this.llI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.llI);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.jump_type);
      paramInt = i;
      if (this.ODt != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ODt);
      }
      i = paramInt;
      if (this.Ooe != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Ooe);
      }
      paramInt = i;
      if (this.Oof != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Oof);
      }
      i = paramInt;
      if (this.TRC != null) {
        i = paramInt + g.a.a.a.oD(9, this.TRC.computeSize());
      }
      AppMethodBeat.o(72542);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72542);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dka localdka = (dka)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72542);
          return -1;
        case 1: 
          localdka.name = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 2: 
          localdka.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 3: 
          localdka.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 4: 
          localdka.llI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 5: 
          localdka.jump_type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72542);
          return 0;
        case 6: 
          localdka.ODt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 7: 
          localdka.Ooe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 8: 
          localdka.Oof = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72542);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dvi localdvi = new dvi();
          if ((localObject != null) && (localObject.length > 0)) {
            localdvi.parseFrom((byte[])localObject);
          }
          localdka.TRC = localdvi;
          paramInt += 1;
        }
        AppMethodBeat.o(72542);
        return 0;
      }
      AppMethodBeat.o(72542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dka
 * JD-Core Version:    0.7.0.1
 */