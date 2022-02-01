package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eul
  extends dyl
{
  public String UvJ;
  public String UvK;
  public String UvL;
  public String UvN;
  public String UvX;
  public int Uwc;
  public String Uwd;
  public int amount;
  public String desc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72607);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UvJ != null) {
        paramVarArgs.f(2, this.UvJ);
      }
      if (this.UvK != null) {
        paramVarArgs.f(3, this.UvK);
      }
      if (this.UvL != null) {
        paramVarArgs.f(4, this.UvL);
      }
      paramVarArgs.aY(5, this.amount);
      if (this.desc != null) {
        paramVarArgs.f(6, this.desc);
      }
      paramVarArgs.aY(7, this.Uwc);
      if (this.UvN != null) {
        paramVarArgs.f(8, this.UvN);
      }
      if (this.UvX != null) {
        paramVarArgs.f(9, this.UvX);
      }
      if (this.Uwd != null) {
        paramVarArgs.f(10, this.Uwd);
      }
      AppMethodBeat.o(72607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label808;
      }
    }
    label808:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UvJ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UvJ);
      }
      i = paramInt;
      if (this.UvK != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UvK);
      }
      paramInt = i;
      if (this.UvL != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UvL);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.amount);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.desc);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.Uwc);
      paramInt = i;
      if (this.UvN != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UvN);
      }
      i = paramInt;
      if (this.UvX != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.UvX);
      }
      paramInt = i;
      if (this.Uwd != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Uwd);
      }
      AppMethodBeat.o(72607);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eul localeul = (eul)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72607);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localeul.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72607);
          return 0;
        case 2: 
          localeul.UvJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 3: 
          localeul.UvK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 4: 
          localeul.UvL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 5: 
          localeul.amount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72607);
          return 0;
        case 6: 
          localeul.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 7: 
          localeul.Uwc = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72607);
          return 0;
        case 8: 
          localeul.UvN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 9: 
          localeul.UvX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72607);
          return 0;
        }
        localeul.Uwd = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72607);
        return 0;
      }
      AppMethodBeat.o(72607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eul
 * JD-Core Version:    0.7.0.1
 */