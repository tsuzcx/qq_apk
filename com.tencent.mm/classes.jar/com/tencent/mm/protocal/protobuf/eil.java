package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eil
  extends com.tencent.mm.cd.a
{
  public String AesKey;
  public int CPw;
  public String Md5;
  public int Sat;
  public String SessionId;
  public int TkK;
  public int Tkv;
  public String Tkx;
  public String Tky;
  public cqh TwK;
  public aam TwL;
  public int Ukt;
  public String Uku;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117925);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.f(1, this.Md5);
      }
      paramVarArgs.aY(2, this.Sat);
      paramVarArgs.aY(3, this.CPw);
      if (this.Tky != null) {
        paramVarArgs.f(4, this.Tky);
      }
      if (this.SessionId != null) {
        paramVarArgs.f(5, this.SessionId);
      }
      paramVarArgs.aY(6, this.Tkv);
      if (this.TwK != null)
      {
        paramVarArgs.oE(7, this.TwK.computeSize());
        this.TwK.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.Ukt);
      if (this.Tkx != null) {
        paramVarArgs.f(9, this.Tkx);
      }
      paramVarArgs.aY(10, this.TkK);
      if (this.Uku != null) {
        paramVarArgs.f(11, this.Uku);
      }
      if (this.AesKey != null) {
        paramVarArgs.f(12, this.AesKey);
      }
      if (this.TwL != null)
      {
        paramVarArgs.oE(13, this.TwL.computeSize());
        this.TwL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label1014;
      }
    }
    label1014:
    for (paramInt = g.a.a.b.b.a.g(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Sat) + g.a.a.b.b.a.bM(3, this.CPw);
      paramInt = i;
      if (this.Tky != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tky);
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SessionId);
      }
      i += g.a.a.b.b.a.bM(6, this.Tkv);
      paramInt = i;
      if (this.TwK != null) {
        paramInt = i + g.a.a.a.oD(7, this.TwK.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.Ukt);
      paramInt = i;
      if (this.Tkx != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Tkx);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.TkK);
      paramInt = i;
      if (this.Uku != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Uku);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.AesKey);
      }
      paramInt = i;
      if (this.TwL != null) {
        paramInt = i + g.a.a.a.oD(13, this.TwL.computeSize());
      }
      AppMethodBeat.o(117925);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eil localeil = (eil)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117925);
          return -1;
        case 1: 
          localeil.Md5 = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 2: 
          localeil.Sat = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117925);
          return 0;
        case 3: 
          localeil.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117925);
          return 0;
        case 4: 
          localeil.Tky = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 5: 
          localeil.SessionId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 6: 
          localeil.Tkv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117925);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cqh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cqh)localObject2).parseFrom((byte[])localObject1);
            }
            localeil.TwK = ((cqh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117925);
          return 0;
        case 8: 
          localeil.Ukt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117925);
          return 0;
        case 9: 
          localeil.Tkx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 10: 
          localeil.TkK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117925);
          return 0;
        case 11: 
          localeil.Uku = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 12: 
          localeil.AesKey = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117925);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aam();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aam)localObject2).parseFrom((byte[])localObject1);
          }
          localeil.TwL = ((aam)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117925);
        return 0;
      }
      AppMethodBeat.o(117925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eil
 * JD-Core Version:    0.7.0.1
 */