package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ebf
  extends dyl
{
  public String UfZ;
  public String Uga;
  public b Ugb;
  public String Ugh;
  public String Ugi;
  public String appid;
  public String scope;
  public String state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82473);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      if (this.scope != null) {
        paramVarArgs.f(3, this.scope);
      }
      if (this.state != null) {
        paramVarArgs.f(4, this.state);
      }
      if (this.UfZ != null) {
        paramVarArgs.f(5, this.UfZ);
      }
      if (this.Ugh != null) {
        paramVarArgs.f(6, this.Ugh);
      }
      if (this.Ugi != null) {
        paramVarArgs.f(7, this.Ugi);
      }
      if (this.Uga != null) {
        paramVarArgs.f(13, this.Uga);
      }
      if (this.Ugb != null) {
        paramVarArgs.c(14, this.Ugb);
      }
      AppMethodBeat.o(82473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label796;
      }
    }
    label796:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.appid);
      }
      i = paramInt;
      if (this.scope != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.scope);
      }
      paramInt = i;
      if (this.state != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.state);
      }
      i = paramInt;
      if (this.UfZ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UfZ);
      }
      paramInt = i;
      if (this.Ugh != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Ugh);
      }
      i = paramInt;
      if (this.Ugi != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Ugi);
      }
      paramInt = i;
      if (this.Uga != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Uga);
      }
      i = paramInt;
      if (this.Ugb != null) {
        i = paramInt + g.a.a.b.b.a.b(14, this.Ugb);
      }
      AppMethodBeat.o(82473);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ebf localebf = (ebf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        default: 
          AppMethodBeat.o(82473);
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
            localebf.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(82473);
          return 0;
        case 2: 
          localebf.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 3: 
          localebf.scope = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 4: 
          localebf.state = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 5: 
          localebf.UfZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 6: 
          localebf.Ugh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 7: 
          localebf.Ugi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 13: 
          localebf.Uga = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82473);
          return 0;
        }
        localebf.Ugb = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(82473);
        return 0;
      }
      AppMethodBeat.o(82473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebf
 * JD-Core Version:    0.7.0.1
 */