package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class duc
  extends com.tencent.mm.cd.a
{
  public ahs RWM;
  public int Uak;
  public int Ual;
  public String Uam;
  public String fZY;
  public String wording;
  public String xml;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207340);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xml != null) {
        paramVarArgs.f(1, this.xml);
      }
      paramVarArgs.aY(2, this.Uak);
      paramVarArgs.aY(3, this.Ual);
      if (this.Uam != null) {
        paramVarArgs.f(4, this.Uam);
      }
      if (this.wording != null) {
        paramVarArgs.f(5, this.wording);
      }
      if (this.fZY != null) {
        paramVarArgs.f(6, this.fZY);
      }
      if (this.RWM != null)
      {
        paramVarArgs.oE(7, this.RWM.computeSize());
        this.RWM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(207340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xml == null) {
        break label620;
      }
    }
    label620:
    for (paramInt = g.a.a.b.b.a.g(1, this.xml) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Uak) + g.a.a.b.b.a.bM(3, this.Ual);
      paramInt = i;
      if (this.Uam != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Uam);
      }
      i = paramInt;
      if (this.wording != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.wording);
      }
      paramInt = i;
      if (this.fZY != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.fZY);
      }
      i = paramInt;
      if (this.RWM != null) {
        i = paramInt + g.a.a.a.oD(7, this.RWM.computeSize());
      }
      AppMethodBeat.o(207340);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207340);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        duc localduc = (duc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207340);
          return -1;
        case 1: 
          localduc.xml = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(207340);
          return 0;
        case 2: 
          localduc.Uak = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(207340);
          return 0;
        case 3: 
          localduc.Ual = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(207340);
          return 0;
        case 4: 
          localduc.Uam = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(207340);
          return 0;
        case 5: 
          localduc.wording = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(207340);
          return 0;
        case 6: 
          localduc.fZY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(207340);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ahs localahs = new ahs();
          if ((localObject != null) && (localObject.length > 0)) {
            localahs.parseFrom((byte[])localObject);
          }
          localduc.RWM = localahs;
          paramInt += 1;
        }
        AppMethodBeat.o(207340);
        return 0;
      }
      AppMethodBeat.o(207340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duc
 * JD-Core Version:    0.7.0.1
 */