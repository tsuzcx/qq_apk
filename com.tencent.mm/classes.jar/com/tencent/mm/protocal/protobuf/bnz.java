package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnz
  extends dyl
{
  public int CPw;
  public String CSe;
  public int RML;
  public String RQH;
  public String SYV;
  public String SYY;
  public String SYZ;
  public int SZa;
  public String SZb;
  public bd Sdp;
  public String SkB;
  public String SlA;
  public String SlB;
  public String Sly;
  public String Slz;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91473);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      if (this.Sly != null) {
        paramVarArgs.f(3, this.Sly);
      }
      if (this.RQH != null) {
        paramVarArgs.f(4, this.RQH);
      }
      if (this.Slz != null) {
        paramVarArgs.f(5, this.Slz);
      }
      if (this.SlA != null) {
        paramVarArgs.f(6, this.SlA);
      }
      if (this.SlB != null) {
        paramVarArgs.f(7, this.SlB);
      }
      if (this.SkB != null) {
        paramVarArgs.f(8, this.SkB);
      }
      if (this.SYV != null) {
        paramVarArgs.f(9, this.SYV);
      }
      paramVarArgs.aY(10, this.RML);
      if (this.CSe != null) {
        paramVarArgs.f(11, this.CSe);
      }
      if (this.SYY != null) {
        paramVarArgs.f(12, this.SYY);
      }
      if (this.SYZ != null) {
        paramVarArgs.f(13, this.SYZ);
      }
      if (this.Sdp != null)
      {
        paramVarArgs.oE(14, this.Sdp.computeSize());
        this.Sdp.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(15, this.CPw);
      paramVarArgs.aY(16, this.SZa);
      if (this.SZb != null) {
        paramVarArgs.f(17, this.SZb);
      }
      AppMethodBeat.o(91473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1294;
      }
    }
    label1294:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt;
      if (this.Sly != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sly);
      }
      paramInt = i;
      if (this.RQH != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RQH);
      }
      i = paramInt;
      if (this.Slz != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Slz);
      }
      paramInt = i;
      if (this.SlA != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SlA);
      }
      i = paramInt;
      if (this.SlB != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SlB);
      }
      paramInt = i;
      if (this.SkB != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SkB);
      }
      i = paramInt;
      if (this.SYV != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SYV);
      }
      i += g.a.a.b.b.a.bM(10, this.RML);
      paramInt = i;
      if (this.CSe != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.CSe);
      }
      i = paramInt;
      if (this.SYY != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.SYY);
      }
      paramInt = i;
      if (this.SYZ != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.SYZ);
      }
      i = paramInt;
      if (this.Sdp != null) {
        i = paramInt + g.a.a.a.oD(14, this.Sdp.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(15, this.CPw) + g.a.a.b.b.a.bM(16, this.SZa);
      paramInt = i;
      if (this.SZb != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.SZb);
      }
      AppMethodBeat.o(91473);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bnz localbnz = (bnz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91473);
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
            localbnz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 2: 
          localbnz.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 3: 
          localbnz.Sly = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 4: 
          localbnz.RQH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 5: 
          localbnz.Slz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 6: 
          localbnz.SlA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 7: 
          localbnz.SlB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 8: 
          localbnz.SkB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 9: 
          localbnz.SYV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 10: 
          localbnz.RML = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91473);
          return 0;
        case 11: 
          localbnz.CSe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 12: 
          localbnz.SYY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 13: 
          localbnz.SYZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bd)localObject2).parseFrom((byte[])localObject1);
            }
            localbnz.Sdp = ((bd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 15: 
          localbnz.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91473);
          return 0;
        case 16: 
          localbnz.SZa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91473);
          return 0;
        }
        localbnz.SZb = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91473);
        return 0;
      }
      AppMethodBeat.o(91473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnz
 * JD-Core Version:    0.7.0.1
 */