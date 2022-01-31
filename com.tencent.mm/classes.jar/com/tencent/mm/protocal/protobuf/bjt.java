package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bjt
  extends com.tencent.mm.bv.a
{
  public String key;
  public String qjy;
  public String value;
  public LinkedList<String> xyf;
  
  public bjt()
  {
    AppMethodBeat.i(90695);
    this.xyf = new LinkedList();
    AppMethodBeat.o(90695);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90696);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(90696);
        throw paramVarArgs;
      }
      if (this.value == null)
      {
        paramVarArgs = new b("Not all required fields were included: value");
        AppMethodBeat.o(90696);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.e(1, this.key);
      }
      if (this.value != null) {
        paramVarArgs.e(2, this.value);
      }
      if (this.qjy != null) {
        paramVarArgs.e(3, this.qjy);
      }
      paramVarArgs.e(4, 1, this.xyf);
      AppMethodBeat.o(90696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label490;
      }
    }
    label490:
    for (int i = e.a.a.b.b.a.f(1, this.key) + 0;; i = 0)
    {
      paramInt = i;
      if (this.value != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.value);
      }
      i = paramInt;
      if (this.qjy != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.qjy);
      }
      paramInt = e.a.a.a.c(4, 1, this.xyf);
      AppMethodBeat.o(90696);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xyf.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(90696);
          throw paramVarArgs;
        }
        if (this.value == null)
        {
          paramVarArgs = new b("Not all required fields were included: value");
          AppMethodBeat.o(90696);
          throw paramVarArgs;
        }
        AppMethodBeat.o(90696);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bjt localbjt = (bjt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(90696);
          return -1;
        case 1: 
          localbjt.key = locala.CLY.readString();
          AppMethodBeat.o(90696);
          return 0;
        case 2: 
          localbjt.value = locala.CLY.readString();
          AppMethodBeat.o(90696);
          return 0;
        case 3: 
          localbjt.qjy = locala.CLY.readString();
          AppMethodBeat.o(90696);
          return 0;
        }
        localbjt.xyf.add(locala.CLY.readString());
        AppMethodBeat.o(90696);
        return 0;
      }
      AppMethodBeat.o(90696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjt
 * JD-Core Version:    0.7.0.1
 */