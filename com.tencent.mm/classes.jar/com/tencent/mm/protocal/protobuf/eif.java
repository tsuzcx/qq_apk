package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eif
  extends com.tencent.mm.cd.a
{
  public ezr Ukm;
  public String Ukn;
  public String Uko;
  public String name;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258271);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.f(1, this.name);
      }
      if (this.value != null) {
        paramVarArgs.f(2, this.value);
      }
      if (this.Ukm != null)
      {
        paramVarArgs.oE(3, this.Ukm.computeSize());
        this.Ukm.writeFields(paramVarArgs);
      }
      if (this.Ukn != null) {
        paramVarArgs.f(4, this.Ukn);
      }
      if (this.Uko != null) {
        paramVarArgs.f(5, this.Uko);
      }
      AppMethodBeat.o(258271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label528;
      }
    }
    label528:
    for (int i = g.a.a.b.b.a.g(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.value != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.value);
      }
      i = paramInt;
      if (this.Ukm != null) {
        i = paramInt + g.a.a.a.oD(3, this.Ukm.computeSize());
      }
      paramInt = i;
      if (this.Ukn != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Ukn);
      }
      i = paramInt;
      if (this.Uko != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Uko);
      }
      AppMethodBeat.o(258271);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(258271);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eif localeif = (eif)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258271);
          return -1;
        case 1: 
          localeif.name = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(258271);
          return 0;
        case 2: 
          localeif.value = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(258271);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ezr localezr = new ezr();
            if ((localObject != null) && (localObject.length > 0)) {
              localezr.parseFrom((byte[])localObject);
            }
            localeif.Ukm = localezr;
            paramInt += 1;
          }
          AppMethodBeat.o(258271);
          return 0;
        case 4: 
          localeif.Ukn = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(258271);
          return 0;
        }
        localeif.Uko = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(258271);
        return 0;
      }
      AppMethodBeat.o(258271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eif
 * JD-Core Version:    0.7.0.1
 */