package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acf
  extends com.tencent.mm.bv.a
{
  public String appId;
  public acq cEC;
  public String cmx;
  public String czp;
  public String desc;
  public String title;
  public int type;
  public String wUL;
  public LinkedList<String> wUM;
  
  public acf()
  {
    AppMethodBeat.i(51396);
    this.wUM = new LinkedList();
    AppMethodBeat.o(51396);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51397);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.czp != null) {
        paramVarArgs.e(3, this.czp);
      }
      if (this.wUL != null) {
        paramVarArgs.e(4, this.wUL);
      }
      if (this.appId != null) {
        paramVarArgs.e(5, this.appId);
      }
      if (this.cmx != null) {
        paramVarArgs.e(6, this.cmx);
      }
      paramVarArgs.e(7, 1, this.wUM);
      paramVarArgs.aO(8, this.type);
      if (this.cEC != null)
      {
        paramVarArgs.iQ(9, this.cEC.computeSize());
        this.cEC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(51397);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label778;
      }
    }
    label778:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.czp != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.czp);
      }
      paramInt = i;
      if (this.wUL != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wUL);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.appId);
      }
      paramInt = i;
      if (this.cmx != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.cmx);
      }
      i = paramInt + e.a.a.a.c(7, 1, this.wUM) + e.a.a.b.b.a.bl(8, this.type);
      paramInt = i;
      if (this.cEC != null) {
        paramInt = i + e.a.a.a.iP(9, this.cEC.computeSize());
      }
      AppMethodBeat.o(51397);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wUM.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51397);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        acf localacf = (acf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(51397);
          return -1;
        case 1: 
          localacf.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51397);
          return 0;
        case 2: 
          localacf.desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51397);
          return 0;
        case 3: 
          localacf.czp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51397);
          return 0;
        case 4: 
          localacf.wUL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51397);
          return 0;
        case 5: 
          localacf.appId = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51397);
          return 0;
        case 6: 
          localacf.cmx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51397);
          return 0;
        case 7: 
          localacf.wUM.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(51397);
          return 0;
        case 8: 
          localacf.type = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51397);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acq();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((acq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localacf.cEC = ((acq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(51397);
        return 0;
      }
      AppMethodBeat.o(51397);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acf
 * JD-Core Version:    0.7.0.1
 */