package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ana
  extends dyy
{
  public LinkedList<cpe> SiG;
  public dov Sxa;
  public String Sxb;
  public String Sxc;
  public String Sxd;
  public String Sxe;
  public float Sxf;
  public String Sxg;
  public float Sxh;
  public String Sxi;
  public String Sxj;
  public int wvP;
  public String wvQ;
  
  public ana()
  {
    AppMethodBeat.i(104361);
    this.SiG = new LinkedList();
    AppMethodBeat.o(104361);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104362);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104362);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SiG);
      if (this.Sxa != null)
      {
        paramVarArgs.oE(3, this.Sxa.computeSize());
        this.Sxa.writeFields(paramVarArgs);
      }
      if (this.Sxb != null) {
        paramVarArgs.f(4, this.Sxb);
      }
      if (this.Sxc != null) {
        paramVarArgs.f(5, this.Sxc);
      }
      if (this.Sxd != null) {
        paramVarArgs.f(6, this.Sxd);
      }
      if (this.Sxe != null) {
        paramVarArgs.f(7, this.Sxe);
      }
      paramVarArgs.i(8, this.Sxf);
      paramVarArgs.aY(9, this.wvP);
      if (this.wvQ != null) {
        paramVarArgs.f(10, this.wvQ);
      }
      if (this.Sxg != null) {
        paramVarArgs.f(11, this.Sxg);
      }
      paramVarArgs.i(12, this.Sxh);
      if (this.Sxi != null) {
        paramVarArgs.f(13, this.Sxi);
      }
      if (this.Sxj != null) {
        paramVarArgs.f(14, this.Sxj);
      }
      AppMethodBeat.o(104362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1218;
      }
    }
    label1218:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SiG);
      paramInt = i;
      if (this.Sxa != null) {
        paramInt = i + g.a.a.a.oD(3, this.Sxa.computeSize());
      }
      i = paramInt;
      if (this.Sxb != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Sxb);
      }
      paramInt = i;
      if (this.Sxc != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Sxc);
      }
      i = paramInt;
      if (this.Sxd != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Sxd);
      }
      paramInt = i;
      if (this.Sxe != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Sxe);
      }
      i = paramInt + (g.a.a.b.b.a.gL(8) + 4) + g.a.a.b.b.a.bM(9, this.wvP);
      paramInt = i;
      if (this.wvQ != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.wvQ);
      }
      i = paramInt;
      if (this.Sxg != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.Sxg);
      }
      i += g.a.a.b.b.a.gL(12) + 4;
      paramInt = i;
      if (this.Sxi != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Sxi);
      }
      i = paramInt;
      if (this.Sxj != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.Sxj);
      }
      AppMethodBeat.o(104362);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SiG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104362);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104362);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ana localana = (ana)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104362);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localana.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cpe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cpe)localObject2).parseFrom((byte[])localObject1);
            }
            localana.SiG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dov();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dov)localObject2).parseFrom((byte[])localObject1);
            }
            localana.Sxa = ((dov)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 4: 
          localana.Sxb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 5: 
          localana.Sxc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 6: 
          localana.Sxd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 7: 
          localana.Sxe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 8: 
          localana.Sxf = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(104362);
          return 0;
        case 9: 
          localana.wvP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104362);
          return 0;
        case 10: 
          localana.wvQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 11: 
          localana.Sxg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 12: 
          localana.Sxh = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(104362);
          return 0;
        case 13: 
          localana.Sxi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104362);
          return 0;
        }
        localana.Sxj = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(104362);
        return 0;
      }
      AppMethodBeat.o(104362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ana
 * JD-Core Version:    0.7.0.1
 */