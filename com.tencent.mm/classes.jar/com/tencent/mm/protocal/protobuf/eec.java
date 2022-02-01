package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eec
  extends dyl
{
  public String CMP;
  public String CNG;
  public String GtP;
  public String RIC;
  public String Uie;
  public String Uif;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155459);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CNG != null) {
        paramVarArgs.f(2, this.CNG);
      }
      if (this.Uie != null) {
        paramVarArgs.f(3, this.Uie);
      }
      if (this.GtP != null) {
        paramVarArgs.f(5, this.GtP);
      }
      if (this.CMP != null) {
        paramVarArgs.f(4, this.CMP);
      }
      if (this.RIC != null) {
        paramVarArgs.f(6, this.RIC);
      }
      if (this.Uif != null) {
        paramVarArgs.f(7, this.Uif);
      }
      AppMethodBeat.o(155459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label652;
      }
    }
    label652:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CNG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CNG);
      }
      i = paramInt;
      if (this.Uie != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Uie);
      }
      paramInt = i;
      if (this.GtP != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.GtP);
      }
      i = paramInt;
      if (this.CMP != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.CMP);
      }
      paramInt = i;
      if (this.RIC != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RIC);
      }
      i = paramInt;
      if (this.Uif != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Uif);
      }
      AppMethodBeat.o(155459);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eec localeec = (eec)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155459);
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
            localeec.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(155459);
          return 0;
        case 2: 
          localeec.CNG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 3: 
          localeec.Uie = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 5: 
          localeec.GtP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 4: 
          localeec.CMP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 6: 
          localeec.RIC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155459);
          return 0;
        }
        localeec.Uif = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(155459);
        return 0;
      }
      AppMethodBeat.o(155459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eec
 * JD-Core Version:    0.7.0.1
 */