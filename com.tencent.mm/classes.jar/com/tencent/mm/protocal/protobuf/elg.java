package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class elg
  extends dyl
{
  public int ExtFlag;
  public int HmZ;
  public int Hna;
  public String MD5;
  public String RIC;
  public eae RNM;
  public int SmH;
  public int TEa;
  public int TEb;
  public evb TUs;
  public int Unr;
  public int Uns;
  public int Unt;
  public String lVG;
  public String lps;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125830);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RNM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(125830);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rWu);
      paramVarArgs.aY(3, this.Hna);
      paramVarArgs.aY(17, this.Unr);
      paramVarArgs.aY(4, this.HmZ);
      if (this.RNM != null)
      {
        paramVarArgs.oE(5, this.RNM.computeSize());
        this.RNM.writeFields(paramVarArgs);
      }
      if (this.lps != null) {
        paramVarArgs.f(6, this.lps);
      }
      paramVarArgs.aY(7, this.TEa);
      paramVarArgs.aY(8, this.TEb);
      if (this.RIC != null) {
        paramVarArgs.f(9, this.RIC);
      }
      paramVarArgs.aY(10, this.Uns);
      paramVarArgs.aY(11, this.SmH);
      if (this.TUs != null)
      {
        paramVarArgs.oE(12, this.TUs.computeSize());
        this.TUs.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(13, this.lVG);
      }
      paramVarArgs.aY(14, this.ExtFlag);
      if (this.MD5 != null) {
        paramVarArgs.f(15, this.MD5);
      }
      paramVarArgs.aY(16, this.Unt);
      AppMethodBeat.o(125830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1296;
      }
    }
    label1296:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWu) + g.a.a.b.b.a.bM(3, this.Hna) + g.a.a.b.b.a.bM(17, this.Unr) + g.a.a.b.b.a.bM(4, this.HmZ);
      paramInt = i;
      if (this.RNM != null) {
        paramInt = i + g.a.a.a.oD(5, this.RNM.computeSize());
      }
      i = paramInt;
      if (this.lps != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.lps);
      }
      i = i + g.a.a.b.b.a.bM(7, this.TEa) + g.a.a.b.b.a.bM(8, this.TEb);
      paramInt = i;
      if (this.RIC != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.RIC);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.Uns) + g.a.a.b.b.a.bM(11, this.SmH);
      paramInt = i;
      if (this.TUs != null) {
        paramInt = i + g.a.a.a.oD(12, this.TUs.computeSize());
      }
      i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.lVG);
      }
      i += g.a.a.b.b.a.bM(14, this.ExtFlag);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.MD5);
      }
      i = g.a.a.b.b.a.bM(16, this.Unt);
      AppMethodBeat.o(125830);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RNM == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(125830);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        elg localelg = (elg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125830);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localelg.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 2: 
          localelg.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125830);
          return 0;
        case 3: 
          localelg.Hna = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125830);
          return 0;
        case 17: 
          localelg.Unr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125830);
          return 0;
        case 4: 
          localelg.HmZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125830);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localelg.RNM = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 6: 
          localelg.lps = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 7: 
          localelg.TEa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125830);
          return 0;
        case 8: 
          localelg.TEb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125830);
          return 0;
        case 9: 
          localelg.RIC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 10: 
          localelg.Uns = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125830);
          return 0;
        case 11: 
          localelg.SmH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125830);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new evb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((evb)localObject2).parseFrom((byte[])localObject1);
            }
            localelg.TUs = ((evb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 13: 
          localelg.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 14: 
          localelg.ExtFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125830);
          return 0;
        case 15: 
          localelg.MD5 = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125830);
          return 0;
        }
        localelg.Unt = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125830);
        return 0;
      }
      AppMethodBeat.o(125830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elg
 * JD-Core Version:    0.7.0.1
 */