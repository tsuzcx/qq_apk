package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eag
  extends com.tencent.mm.bx.a
{
  public String abfo;
  public dfj abfp;
  public boolean abfq = false;
  public String action;
  public String className;
  public String dataPath;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122524);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.className != null) {
        paramVarArgs.g(1, this.className);
      }
      if (this.dataPath != null) {
        paramVarArgs.g(2, this.dataPath);
      }
      if (this.action != null) {
        paramVarArgs.g(3, this.action);
      }
      if (this.abfo != null) {
        paramVarArgs.g(4, this.abfo);
      }
      if (this.abfp != null)
      {
        paramVarArgs.qD(5, this.abfp.computeSize());
        this.abfp.writeFields(paramVarArgs);
      }
      paramVarArgs.di(6, this.abfq);
      AppMethodBeat.o(122524);
      return 0;
    }
    if (paramInt == 1) {
      if (this.className == null) {
        break label568;
      }
    }
    label568:
    for (int i = i.a.a.b.b.a.h(1, this.className) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dataPath != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.dataPath);
      }
      i = paramInt;
      if (this.action != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.action);
      }
      paramInt = i;
      if (this.abfo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abfo);
      }
      i = paramInt;
      if (this.abfp != null) {
        i = paramInt + i.a.a.a.qC(5, this.abfp.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(6);
      AppMethodBeat.o(122524);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122524);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eag localeag = (eag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122524);
          return -1;
        case 1: 
          localeag.className = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 2: 
          localeag.dataPath = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 3: 
          localeag.action = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 4: 
          localeag.abfo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dfj localdfj = new dfj();
            if ((localObject != null) && (localObject.length > 0)) {
              localdfj.parseFrom((byte[])localObject);
            }
            localeag.abfp = localdfj;
            paramInt += 1;
          }
          AppMethodBeat.o(122524);
          return 0;
        }
        localeag.abfq = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(122524);
        return 0;
      }
      AppMethodBeat.o(122524);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eag
 * JD-Core Version:    0.7.0.1
 */