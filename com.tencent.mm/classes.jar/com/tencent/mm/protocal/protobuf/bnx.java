package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnx
  extends dyl
{
  public int CPw;
  public String CSe;
  public int RML;
  public String RQH;
  public String SYV;
  public String SkB;
  public String SlA;
  public String SlB;
  public String Sly;
  public String Slz;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91471);
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
      paramVarArgs.aY(12, this.CPw);
      AppMethodBeat.o(91471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label932;
      }
    }
    label932:
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
      i = g.a.a.b.b.a.bM(12, this.CPw);
      AppMethodBeat.o(91471);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bnx localbnx = (bnx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91471);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localbnx.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91471);
          return 0;
        case 2: 
          localbnx.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91471);
          return 0;
        case 3: 
          localbnx.Sly = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91471);
          return 0;
        case 4: 
          localbnx.RQH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91471);
          return 0;
        case 5: 
          localbnx.Slz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91471);
          return 0;
        case 6: 
          localbnx.SlA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91471);
          return 0;
        case 7: 
          localbnx.SlB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91471);
          return 0;
        case 8: 
          localbnx.SkB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91471);
          return 0;
        case 9: 
          localbnx.SYV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91471);
          return 0;
        case 10: 
          localbnx.RML = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91471);
          return 0;
        case 11: 
          localbnx.CSe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91471);
          return 0;
        }
        localbnx.CPw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91471);
        return 0;
      }
      AppMethodBeat.o(91471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnx
 * JD-Core Version:    0.7.0.1
 */