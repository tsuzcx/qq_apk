package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ds
  extends com.tencent.mm.cd.a
{
  public int Ilb;
  public String ImY;
  public String InV;
  public String RJf;
  public String RJg;
  public aos RJh;
  public int RJi;
  public int channel;
  public String llO;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91349);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RJf == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.RJg == null)
      {
        paramVarArgs = new b("Not all required fields were included: payok_checksign");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.RJf != null) {
        paramVarArgs.f(1, this.RJf);
      }
      if (this.InV != null) {
        paramVarArgs.f(2, this.InV);
      }
      paramVarArgs.aY(3, this.channel);
      paramVarArgs.aY(4, this.Ilb);
      paramVarArgs.aY(5, this.scene);
      if (this.RJg != null) {
        paramVarArgs.f(6, this.RJg);
      }
      if (this.RJh != null)
      {
        paramVarArgs.oE(7, this.RJh.computeSize());
        this.RJh.writeFields(paramVarArgs);
      }
      if (this.llO != null) {
        paramVarArgs.f(8, this.llO);
      }
      if (this.ImY != null) {
        paramVarArgs.f(9, this.ImY);
      }
      paramVarArgs.aY(10, this.RJi);
      AppMethodBeat.o(91349);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RJf == null) {
        break label868;
      }
    }
    label868:
    for (paramInt = g.a.a.b.b.a.g(1, this.RJf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.InV != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.InV);
      }
      i = i + g.a.a.b.b.a.bM(3, this.channel) + g.a.a.b.b.a.bM(4, this.Ilb) + g.a.a.b.b.a.bM(5, this.scene);
      paramInt = i;
      if (this.RJg != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RJg);
      }
      i = paramInt;
      if (this.RJh != null) {
        i = paramInt + g.a.a.a.oD(7, this.RJh.computeSize());
      }
      paramInt = i;
      if (this.llO != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.llO);
      }
      i = paramInt;
      if (this.ImY != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.ImY);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.RJi);
      AppMethodBeat.o(91349);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RJf == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91349);
          throw paramVarArgs;
        }
        if (this.RJg == null)
        {
          paramVarArgs = new b("Not all required fields were included: payok_checksign");
          AppMethodBeat.o(91349);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91349);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ds localds = (ds)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91349);
          return -1;
        case 1: 
          localds.RJf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 2: 
          localds.InV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 3: 
          localds.channel = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91349);
          return 0;
        case 4: 
          localds.Ilb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91349);
          return 0;
        case 5: 
          localds.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91349);
          return 0;
        case 6: 
          localds.RJg = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aos localaos = new aos();
            if ((localObject != null) && (localObject.length > 0)) {
              localaos.parseFrom((byte[])localObject);
            }
            localds.RJh = localaos;
            paramInt += 1;
          }
          AppMethodBeat.o(91349);
          return 0;
        case 8: 
          localds.llO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 9: 
          localds.ImY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91349);
          return 0;
        }
        localds.RJi = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91349);
        return 0;
      }
      AppMethodBeat.o(91349);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ds
 * JD-Core Version:    0.7.0.1
 */