package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ajo
  extends com.tencent.mm.cd.a
{
  public String CRQ;
  public int HmZ;
  public int Hna;
  public String MD5;
  public String RII;
  public String ScZ;
  public eae StX;
  public String StY;
  public String StZ;
  public String Sua;
  public int Sub;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109446);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.StX == null)
      {
        paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(109446);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.f(1, this.MD5);
      }
      paramVarArgs.aY(2, this.Hna);
      paramVarArgs.aY(3, this.HmZ);
      if (this.StX != null)
      {
        paramVarArgs.oE(4, this.StX.computeSize());
        this.StX.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.rWu);
      if (this.CRQ != null) {
        paramVarArgs.f(6, this.CRQ);
      }
      if (this.StY != null) {
        paramVarArgs.f(7, this.StY);
      }
      if (this.StZ != null) {
        paramVarArgs.f(8, this.StZ);
      }
      if (this.Sua != null) {
        paramVarArgs.f(9, this.Sua);
      }
      if (this.RII != null) {
        paramVarArgs.f(10, this.RII);
      }
      paramVarArgs.aY(11, this.Sub);
      if (this.ScZ != null) {
        paramVarArgs.f(12, this.ScZ);
      }
      AppMethodBeat.o(109446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label944;
      }
    }
    label944:
    for (paramInt = g.a.a.b.b.a.g(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Hna) + g.a.a.b.b.a.bM(3, this.HmZ);
      paramInt = i;
      if (this.StX != null) {
        paramInt = i + g.a.a.a.oD(4, this.StX.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.rWu);
      paramInt = i;
      if (this.CRQ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CRQ);
      }
      i = paramInt;
      if (this.StY != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.StY);
      }
      paramInt = i;
      if (this.StZ != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.StZ);
      }
      i = paramInt;
      if (this.Sua != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Sua);
      }
      paramInt = i;
      if (this.RII != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.RII);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.Sub);
      paramInt = i;
      if (this.ScZ != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.ScZ);
      }
      AppMethodBeat.o(109446);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.StX == null)
        {
          paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
          AppMethodBeat.o(109446);
          throw paramVarArgs;
        }
        AppMethodBeat.o(109446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ajo localajo = (ajo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(109446);
          return -1;
        case 1: 
          localajo.MD5 = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 2: 
          localajo.Hna = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(109446);
          return 0;
        case 3: 
          localajo.HmZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(109446);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eae localeae = new eae();
            if ((localObject != null) && (localObject.length > 0)) {
              localeae.dd((byte[])localObject);
            }
            localajo.StX = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(109446);
          return 0;
        case 5: 
          localajo.rWu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(109446);
          return 0;
        case 6: 
          localajo.CRQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 7: 
          localajo.StY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 8: 
          localajo.StZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 9: 
          localajo.Sua = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 10: 
          localajo.RII = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 11: 
          localajo.Sub = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(109446);
          return 0;
        }
        localajo.ScZ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(109446);
        return 0;
      }
      AppMethodBeat.o(109446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajo
 * JD-Core Version:    0.7.0.1
 */