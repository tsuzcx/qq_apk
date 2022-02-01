package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chv
  extends com.tencent.mm.bw.a
{
  public String Mnh;
  public String Mni;
  public eok Mnj;
  public String Mnk;
  public String Mnl;
  public String Mnm;
  public String Mnn;
  public String desc;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200211);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.e(1, this.name);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.Mnh != null) {
        paramVarArgs.e(3, this.Mnh);
      }
      if (this.Mni != null) {
        paramVarArgs.e(4, this.Mni);
      }
      if (this.Mnj != null)
      {
        paramVarArgs.ni(5, this.Mnj.computeSize());
        this.Mnj.writeFields(paramVarArgs);
      }
      if (this.Mnk != null) {
        paramVarArgs.e(6, this.Mnk);
      }
      if (this.Mnl != null) {
        paramVarArgs.e(7, this.Mnl);
      }
      if (this.Mnm != null) {
        paramVarArgs.e(8, this.Mnm);
      }
      if (this.Mnn != null) {
        paramVarArgs.e(9, this.Mnn);
      }
      AppMethodBeat.o(200211);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label798;
      }
    }
    label798:
    for (int i = g.a.a.b.b.a.f(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.Mnh != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mnh);
      }
      paramInt = i;
      if (this.Mni != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mni);
      }
      i = paramInt;
      if (this.Mnj != null) {
        i = paramInt + g.a.a.a.nh(5, this.Mnj.computeSize());
      }
      paramInt = i;
      if (this.Mnk != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Mnk);
      }
      i = paramInt;
      if (this.Mnl != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Mnl);
      }
      paramInt = i;
      if (this.Mnm != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Mnm);
      }
      i = paramInt;
      if (this.Mnn != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Mnn);
      }
      AppMethodBeat.o(200211);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200211);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        chv localchv = (chv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200211);
          return -1;
        case 1: 
          localchv.name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200211);
          return 0;
        case 2: 
          localchv.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200211);
          return 0;
        case 3: 
          localchv.Mnh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200211);
          return 0;
        case 4: 
          localchv.Mni = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200211);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eok();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eok)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchv.Mnj = ((eok)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200211);
          return 0;
        case 6: 
          localchv.Mnk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200211);
          return 0;
        case 7: 
          localchv.Mnl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200211);
          return 0;
        case 8: 
          localchv.Mnm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200211);
          return 0;
        }
        localchv.Mnn = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(200211);
        return 0;
      }
      AppMethodBeat.o(200211);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chv
 * JD-Core Version:    0.7.0.1
 */