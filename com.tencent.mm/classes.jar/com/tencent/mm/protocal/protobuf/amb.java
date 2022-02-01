package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amb
  extends dyl
{
  public String RFt;
  public String RQY;
  public String RRd;
  public int Swu;
  public int Swv;
  public String Sww;
  public String Swx;
  public String Swy;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(251645);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.rWI != null) {
        paramVarArgs.f(2, this.rWI);
      }
      if (this.RFt != null) {
        paramVarArgs.f(3, this.RFt);
      }
      paramVarArgs.aY(4, this.Swu);
      paramVarArgs.aY(5, this.Swv);
      if (this.RQY != null) {
        paramVarArgs.f(6, this.RQY);
      }
      if (this.Sww != null) {
        paramVarArgs.f(7, this.Sww);
      }
      if (this.RRd != null) {
        paramVarArgs.f(8, this.RRd);
      }
      if (this.Swx != null) {
        paramVarArgs.f(9, this.Swx);
      }
      if (this.Swy != null) {
        paramVarArgs.f(10, this.Swy);
      }
      AppMethodBeat.o(251645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label804;
      }
    }
    label804:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rWI);
      }
      i = paramInt;
      if (this.RFt != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RFt);
      }
      i = i + g.a.a.b.b.a.bM(4, this.Swu) + g.a.a.b.b.a.bM(5, this.Swv);
      paramInt = i;
      if (this.RQY != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RQY);
      }
      i = paramInt;
      if (this.Sww != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Sww);
      }
      paramInt = i;
      if (this.RRd != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RRd);
      }
      i = paramInt;
      if (this.Swx != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Swx);
      }
      paramInt = i;
      if (this.Swy != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Swy);
      }
      AppMethodBeat.o(251645);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(251645);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        amb localamb = (amb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(251645);
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
            localamb.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(251645);
          return 0;
        case 2: 
          localamb.rWI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251645);
          return 0;
        case 3: 
          localamb.RFt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251645);
          return 0;
        case 4: 
          localamb.Swu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(251645);
          return 0;
        case 5: 
          localamb.Swv = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(251645);
          return 0;
        case 6: 
          localamb.RQY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251645);
          return 0;
        case 7: 
          localamb.Sww = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251645);
          return 0;
        case 8: 
          localamb.RRd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251645);
          return 0;
        case 9: 
          localamb.Swx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251645);
          return 0;
        }
        localamb.Swy = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(251645);
        return 0;
      }
      AppMethodBeat.o(251645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amb
 * JD-Core Version:    0.7.0.1
 */