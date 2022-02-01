package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class wv
  extends dyy
{
  public String Imv;
  public LinkedList<Integer> SiB;
  public int SiD;
  public String SiN;
  public String SiT;
  public String SiW;
  public String SiY;
  public String SiZ;
  public String Sjc;
  public String Sjd;
  public String Sje;
  public String desc;
  public int fwx;
  public String tVo;
  
  public wv()
  {
    AppMethodBeat.i(72440);
    this.SiB = new LinkedList();
    AppMethodBeat.o(72440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72441);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      if (this.SiT != null) {
        paramVarArgs.f(4, this.SiT);
      }
      paramVarArgs.e(5, 2, this.SiB);
      if (this.desc != null) {
        paramVarArgs.f(6, this.desc);
      }
      if (this.Sjc != null) {
        paramVarArgs.f(7, this.Sjc);
      }
      if (this.Imv != null) {
        paramVarArgs.f(8, this.Imv);
      }
      if (this.SiW != null) {
        paramVarArgs.f(9, this.SiW);
      }
      if (this.SiY != null) {
        paramVarArgs.f(10, this.SiY);
      }
      if (this.SiZ != null) {
        paramVarArgs.f(11, this.SiZ);
      }
      paramVarArgs.aY(12, this.SiD);
      if (this.SiN != null) {
        paramVarArgs.f(13, this.SiN);
      }
      if (this.Sjd != null) {
        paramVarArgs.f(14, this.Sjd);
      }
      if (this.Sje != null) {
        paramVarArgs.f(15, this.Sje);
      }
      AppMethodBeat.o(72441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1167;
      }
    }
    label1167:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.SiT != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.SiT);
      }
      i += g.a.a.a.c(5, 2, this.SiB);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.desc);
      }
      i = paramInt;
      if (this.Sjc != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Sjc);
      }
      paramInt = i;
      if (this.Imv != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Imv);
      }
      i = paramInt;
      if (this.SiW != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SiW);
      }
      paramInt = i;
      if (this.SiY != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SiY);
      }
      i = paramInt;
      if (this.SiZ != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.SiZ);
      }
      i += g.a.a.b.b.a.bM(12, this.SiD);
      paramInt = i;
      if (this.SiN != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.SiN);
      }
      i = paramInt;
      if (this.Sjd != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.Sjd);
      }
      paramInt = i;
      if (this.Sje != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.Sje);
      }
      AppMethodBeat.o(72441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SiB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        wv localwv = (wv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72441);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localwv.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(72441);
          return 0;
        case 2: 
          localwv.fwx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72441);
          return 0;
        case 3: 
          localwv.tVo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 4: 
          localwv.SiT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 5: 
          localwv.SiB.add(Integer.valueOf(((g.a.a.a.a)localObject).abFh.AK()));
          AppMethodBeat.o(72441);
          return 0;
        case 6: 
          localwv.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 7: 
          localwv.Sjc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 8: 
          localwv.Imv = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 9: 
          localwv.SiW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 10: 
          localwv.SiY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 11: 
          localwv.SiZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 12: 
          localwv.SiD = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72441);
          return 0;
        case 13: 
          localwv.SiN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 14: 
          localwv.Sjd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72441);
          return 0;
        }
        localwv.Sje = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72441);
        return 0;
      }
      AppMethodBeat.o(72441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wv
 * JD-Core Version:    0.7.0.1
 */